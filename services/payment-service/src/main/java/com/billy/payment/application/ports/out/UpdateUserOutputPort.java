package com.billy.payment.application.ports.out;

import com.billy.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);
}
