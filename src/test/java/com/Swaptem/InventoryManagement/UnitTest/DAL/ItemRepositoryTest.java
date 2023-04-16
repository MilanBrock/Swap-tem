package com.Swaptem.InventoryManagement.UnitTest.DAL;

import com.Swaptem.InventoryManagement.Entity.Item;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ItemRepositoryTest implements ItemRepositoryInterface {

    public ArrayList<Item> items;

    public ItemRepositoryTest(){
        items = new ArrayList<>();
        ListFill();
    }

    public void ListFill(){
        Item item1 = new Item(1,"ItemEen","ItemEenDescription");
        Item item2 = new Item(2,"ItemTwee","ItemTweeDescription");
        Item item3 = new Item(3,"ItemDrie","ItemDrieDescription");
        items.add(item1);
        items.add(item2);
        items.add(item3);
    }


    // Custom methods
    @Override
    public <S extends Item> S save(S entity) {
        items.add(entity);
        entity.setId(items.size()+1);
        return entity;
    }

    @Override
    public Optional<Item> findById(Integer integer) {
        Optional<Item> itemResult = Optional.empty();
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getId() == integer){
                itemResult = Optional.ofNullable(items.get(i));
            }
        }
        return itemResult;
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public void deleteById(Integer integer) {
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getId() == integer){
                items.remove(i);
            }
        }
    }


    // Unused methods

    @Override
    public void flush() {
    }

    @Override
    public <S extends Item> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Item> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Item> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Item getOne(Integer integer) {
        return null;
    }

    @Override
    public Item getById(Integer integer) {
        return null;
    }

    @Override
    public Item getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Item> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Item> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Item> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Item> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Item> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Item> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Item, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Item> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Item> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Item entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Item> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Item> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return null;
    }
}
