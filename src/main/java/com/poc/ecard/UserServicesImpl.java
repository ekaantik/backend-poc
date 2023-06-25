package com.poc.ecard;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public List<UserDetails> getUser() {
        return userDetailsRepository.findAll();
    }


    @Override
    public User addUser(User user) {

        try{
            for (int i=0;i<user.getPhoneBookNum().size();i++)
            {
                UserDetails userDetails=new UserDetails(user.getUserNum(), user.getPhoneBookNum().get(i), user.getQrCodePath(), user.getByteCode());
                UserDetails userResponse=userDetailsRepository.save(userDetails);
            }
        }
        catch(Exception e){

            System.out.println(e.getMessage());
        }
        String response="user "+ user.getUserNum()+" successfully added to the system";
        User userAddResponse=new User();
        userAddResponse.setResponse(response);
        return userAddResponse;
    }

    @Override
    public User findCommonContacts(User user) {

        List<String> u1 = userDetailsRepository.getCommonContactsByUserDetails(user.getUserNum(), user.getUserNumToSearch());
//        System.out.println(u1);
        user.setCommonContacts(u1);
        if (u1.isEmpty()){
            user.setResponse("Empty String");
        }
        else{
            user.setResponse( user.getUserNum()+ " searches for "+ user.getUserNumToSearch()+  " and we find "+ user.getCommonContacts()+ " common contacts");
        }
        return user;
    }

    @Override
    public User generateQRCode(User user) throws WriterException, IOException {
        String qrCodePath = "/home/meet/Desktop/pooc/beckend-poc/src/main/resources/qrcode//";
        String qrCodeName = qrCodePath + user.getUserNum() + "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "User Number: " + user.getUserNum(), BarcodeFormat.QR_CODE, 400, 400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        user.setQrCodePath(qrCodeName);
        return null;
    }

    @Override
    public User generateByteCode(User user) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "User Number: " + user.getUserNum(), BarcodeFormat.QR_CODE, 400, 400);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig(0xFF000002, 0xFFFFC041);

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream, con);
        byte[] pngData = pngOutputStream.toByteArray();
        user.setByteCode(pngData);
        return null;
    }
}