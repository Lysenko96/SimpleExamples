package info.lysenko.anton.midi;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.play();
    }

    public void play(){
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println(sequencer.getDeviceInfo());
        } catch (MidiUnavailableException e){
            e.printStackTrace();
        }
    }
}
