package org.example.spring.di.circle;

/**
 * @author chenlixin at 2017年1月20日 下午6:54:16
 */
public class CircleSecond {

    private CircleThree ct;
    
    public CircleSecond() {
        super();
    }
    
    public CircleSecond(CircleThree ct) {
        this.ct = ct;
    }
    
    public void setCt(CircleThree ct) {
        this.ct = ct;
    }
    
    public void cs() {
        ct.ct();
    }
}
