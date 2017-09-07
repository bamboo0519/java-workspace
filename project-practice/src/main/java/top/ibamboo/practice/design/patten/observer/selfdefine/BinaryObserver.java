package top.ibamboo.practice.design.patten.observer.selfdefine;

/**
 * Created by C0907 on 2017/8/30.
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public boolean update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
        return true;
    }
}
