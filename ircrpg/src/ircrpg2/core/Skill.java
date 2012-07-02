/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
abstract public class Skill implements Named {
    final public static int MAX_PROGRESS = 10000;

    private int progress;
    public Skill() {
    progress = 0;
    }

    //abstract public void use(RPGCharacter user);

    abstract public String getName();
    public int getProgress() {
    return progress;
    }
    public double getProgressAsDouble() {
    return progress/(double)MAX_PROGRESS;
    }
    public void setProgress(int progress) {
    if (progress < 0 || progress > MAX_PROGRESS) {
    throw new IllegalArgumentException("Progress must be between 0 and" + MAX_PROGRESS);
    }
    this.progress = progress;
    }

    public void increase(int add) {
    this.progress+=add;
    if (progress > MAX_PROGRESS) {progress = MAX_PROGRESS;}
    }
    public void decrease(int sub) {
    this.progress-=sub;
    if (progress < 0) {progress = 0;}
    }
}
