package io.muic.ooc.pos.user;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface UserRepository extends JpaRepository<UserModel, Long>{
//    <T> List<T> findAllByIsShowTrue(Class<T> projection);
//    <T> List<T> findAllByIsShowIsNotNull(Class<T> projection);
//}


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{

    UserModel findByUsername(String username);

}
