package top.ibamboo.practice.design.patten.observer.selfdefine;

/**
 * Created by C0907 on 2017/8/30.
 */
public class HexaObserver extends Observer {
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public boolean update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
        return true;
    }
}
