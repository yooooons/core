package hello.core.singleton;

public class SingletonService {
    //static영역에 객체를 딱 1개만 생성해둔다
    private static final SingletonService instance=new SingletonService();
    //생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막음
    private SingletonService() {

    }
    //public으로 열어서 객체인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
    //기존 구현체들을 싱글톤예제처럼 싱글톤패턴화 시킨뒤 Appconfig return에 new 대신 getInstance 를 사용
    //스프링컨테이너를 사용하면 기본적으로 싱글톤으로 만들어서 관리를 해준다. 알아서 있는  객체를 재활용해준다 , 성능이 좋아진다

}
