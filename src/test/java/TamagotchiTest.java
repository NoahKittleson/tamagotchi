import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
  public void Tamagotchi_instantiatesCorrectly_true() {
    Tamagotchi myTamagotchi = new Tamagotchi("Tom", "Blue");
    assertEquals(true, myTamagotchi instanceof Tamagotchi);
  }

  @Test
  public void Tamagotchi_getsFed_statChange() {
    Tamagotchi myTamagotchi = new Tamagotchi("Tom", "Blue");
    myTamagotchi.feed();
    assertEquals(80, myTamagotchi.mHunger);
    assertEquals(60, myTamagotchi.mHappiness);
    assertEquals(40, myTamagotchi.mEnergy);
  }

  @Test
  public void Tamagotchi_getsExercise_statChange() {
    Tamagotchi myTamagotchi = new Tamagotchi("Tom", "Blue");
    myTamagotchi.exercise();
    assertEquals(40, myTamagotchi.mHappiness);
    assertEquals(40, myTamagotchi.mEnergy);
    assertEquals(80, myTamagotchi.mDiscipline);
  }
}
