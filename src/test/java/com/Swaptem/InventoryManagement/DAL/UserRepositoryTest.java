package com.Swaptem.InventoryManagement.DAL;

import com.Swaptem.InventoryManagement.Entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UserRepositoryTest implements UserRepositoryInterface {

    public ArrayList<User> users;

    public UserRepositoryTest(){
        users = new ArrayList<>();
        ListFill();
    }

    public void ListFill(){
        User user1 = new User(1, "UsernameEEN", "UserPasswordEEN", 500);
        User user2 = new User(2, "UsernameTWEE", "UserPasswordTWEE", 300);
        User user3 = new User(3, "UsernameDRIE", "UserPasswordDRIE", 865);
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }



    // Custom methods

    @Override
    public <S extends User> S save(S entity) {
        users.add(entity);
        entity.setUserId(users.size()+1);
        return entity;
    }


    @Override
    public Optional<User> findById(Integer integer) {
        Optional<User> userResult = Optional.empty();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserId() == integer){
                userResult = Optional.ofNullable(users.get(i));
            }
        }
        return userResult;
    }



    @Override
    public List<User> findAll() {
        return users;
    }


    @Override
    public void deleteById(Integer integer) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserId() == integer){
                users.remove(i);
            }
        }
    }



    // Unused methods

    @Override
    public void flush() {

    }

    @Override
    public <S extends User> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<User> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(Integer integer) {
        return null;
    }

    @Override
    public User getById(Integer integer) {
        return null;
    }

    @Override
    public User getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }



    @Override
    public <S extends User> List<S> saveAll(Iterable<S> entities) {
        return null;
    }



    @Override
    public boolean existsById(Integer integer) {
        return false;
    }



    @Override
    public List<User> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }
}
