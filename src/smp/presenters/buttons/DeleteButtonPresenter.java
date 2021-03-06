package smp.presenters.buttons;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import smp.models.staff.StaffArrangement;
import smp.models.stateMachine.ProgramState;
import smp.models.stateMachine.Settings;
import smp.models.stateMachine.StateMachine;
import smp.models.stateMachine.Variables;
import smp.presenters.api.button.ImagePushButton;

/**
 * This is a button that deletes a song from an arrangement.
 *
 * @author RehdBlob
 * @since 2014.07.27
 */
public class DeleteButtonPresenter extends ImagePushButton {

	//TODO: auto-add these model comments
	//====Models====
	private ObjectProperty<StaffArrangement> theArrangement;
	private ObjectProperty<ProgramState> programState;
	private IntegerProperty arrangementListSelectedIndex;

	/**
     * Default constructor.
     *
     * @param deleteButton
     *            The <code>ImageView</code> object that we are going to make
     *            into a button.
     * @param ct
     *            The FXML controller object.
     * @param im
     *            The Image loader object.
     */
    public DeleteButtonPresenter(ImageView deleteButton) {
        super(deleteButton);
        this.theArrangement = Variables.theArrangement;
        this.arrangementListSelectedIndex = Variables.arrangementListSelectedIndex;
        this.programState = StateMachine.getState();
        setupViewUpdater();
    }

    @Override
    protected void reactPressed(MouseEvent event) {
        if (this.programState.get() != ProgramState.ARR_PLAYING) {
            if ((Settings.debug & 0b100000) != 0)
                System.out.println("Delete song");
            ObservableList<String> l = this.theArrangement.get().getTheSequenceNames();
			int x = this.arrangementListSelectedIndex.get();
            if (x != -1) {
                StateMachine.setArrModified(true);
                this.theArrangement.get().remove(x);
                l.remove(x);
            }
        }
    }

    @Override
    protected void reactReleased(MouseEvent event) {

    }
    
    private void setupViewUpdater() {
		theImage.setVisible(false);
    	this.programState.addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				if (newValue.equals(ProgramState.EDITING))
					theImage.setVisible(false);
				else if (newValue.equals(ProgramState.ARR_EDITING))
					theImage.setVisible(true);
			}
		});
	}
}
