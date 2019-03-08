package service;

public class Test {
UserService userService = new UserService();

public void test(){
    System.out.println(userService.findAll());
}

}
