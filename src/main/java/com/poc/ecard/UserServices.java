package com.poc.ecard;

import com.google.zxing.WriterException;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.List;

@ComponentScan
public interface UserServices {



    List<UserDetails> getUser();
    User addUser(User user);
    User findCommonContacts(User user);

    User generateQRCode(User user) throws WriterException, IOException;

    User generateByteCode(User user) throws WriterException, IOException;
}
