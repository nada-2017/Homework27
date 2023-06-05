package com.example.homework27.Repository;

import com.example.homework27.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<MyUser,Integer> {

    MyUser findMyUserByUsername(String name);

    MyUser findMyUserById(Integer id);
}
