package top.ibamboo.practice.design.patten.observer.selfdefine;

/**
 * Created by bamboo on 2017/8/30.
 */
public class OctalObserver extends Observer {


    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public boolean update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
        return true;
    }
}
