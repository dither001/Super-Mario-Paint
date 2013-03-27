package smp.components.staff.sequences;
import smp.stateMachine.Settings;

/**
 * An event on the Super Mario Paint staff.
 * @author RehdBlob
 * @since 2012.09.24
 */
public abstract class AbstractStaffEvent implements StaffEvent {

    /**
     * The line number that this staff event occurs at.
     */
    protected int lineNum;

    /**
     * The integer representation of the measure that this staff
     * event occurs at.
     */
    protected int measureNum;

    /**
     * Denotes the location of this event within a measure.
     */
    protected int measureLineNum;

    public AbstractStaffEvent(int num) {
        lineNum = num;
        setMeasureNum(num);
        setMeasureLineNum(num);
    }

    /**
     * Sets the measure number of this staff event given
     * an integer that denotes the line number that this
     * event occurs at.
     * @param num An integer representation that denotes
     * the location of the event.
     */
    protected void setMeasureNum(int num) {
        if (isMeasureNumValid(num)) {

        }
    }

    /**
     * Tells us whether this measure number is valid.
     * @param num The measure number we want to check.
     * @return
     */
    protected static boolean isMeasureNumValid(int num) {
        return (!Settings.LIM_96_MEASURES && num >= 0) || (num >= 0 && num <= 96);
    }

    /**
     * Sets the measure line number of this staff event
     * given an integer that denotes the line number
     * that this event occurs at.
     * @param num An integer representation that denotes the
     * location of the event.
     */
    protected void setMeasureLineNum(int num) {
        ;
    }

    @Override
    public int getLineNum() {
        return lineNum;
    }

    @Override
    public int getMeasureNum() {
        return measureNum;
    }

    @Override
    public int getMeasureLineNum() {
        return measureLineNum;
    }


}
