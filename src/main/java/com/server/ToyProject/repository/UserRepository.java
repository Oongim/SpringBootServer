package com.server.ToyProject.repository;

import com.server.ToyProject.entity.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Spring은 동일한 이름을 가진 빈에서 이 저장소 인터페이스를 자동으로 구현합니다(대소문자 변경 — userRepository로 호출됨).
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUuid(String uuid);
}
