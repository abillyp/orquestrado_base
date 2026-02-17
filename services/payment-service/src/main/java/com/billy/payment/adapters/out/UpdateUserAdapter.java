package com.billy.payment.adapters.out;

import com.billy.payment.adapters.out.repository.UserRepository;
import com.billy.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.billy.payment.application.core.domain.User;
import com.billy.payment.application.ports.out.UpdateUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public void update(User user) {
        userRepository.save(userEntityMapper.toUserEntity(user));

    }
}
