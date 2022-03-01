package com.spring.springbootfeatures.service;

import com.spring.springbootfeatures.pojo.User;
import com.spring.springbootfeatures.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class UserService {

    Object target;

    @Autowired
    private UserRepository userRepository;

    @Async
    public CompletableFuture<List<User>> saveUsers(MultipartFile  file) throws Exception{
        long start = System.currentTimeMillis();
        List<User> users = parseCSVFile(file);
        System.out.println("saving list of user of size {} "+users.size()+" "+Thread.currentThread().getName());
        userRepository.saveAll(users);
        long end= System.currentTimeMillis();
        System.out.println("Total time {}"+(end-start));
        return CompletableFuture.completedFuture(users);
    }
    @Async
    public CompletableFuture<List<User>> findAllUsers(){
        System.out.println("get list of users by "+Thread.currentThread().getName());
        List<User> users = userRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }
    private List<User> parseCSVFile(final MultipartFile file) throws Exception{
        final List<User> users = new ArrayList<>();
        try{
            try(final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                String line;
                while((line = br.readLine()) != null){
                    final String[] data = line.split(",");
                    final User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);
                    users.add(user);
                }
                return users;
            }
            } catch (final IOException e){
             //   logger.
                throw new Exception("failed to parse csv file {}",e);
            }

    }
}
