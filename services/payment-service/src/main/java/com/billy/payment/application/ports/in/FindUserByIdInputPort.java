package com.billy.payment.application.ports.in;

import com.billy.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Integer id);
}
