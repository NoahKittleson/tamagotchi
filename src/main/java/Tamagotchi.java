public class Tamagotchi {
  private String mName;
  private String mColor;
  public int mHunger;
  public int mHappiness;
  public int mEnergy;
  public int mDiscipline;
  private boolean mIsAlive;


  public Tamagotchi(String name, String color) {
    mEnergy = 50;
    mHappiness = 50;
    mHunger = 50;
    mDiscipline = 50;
    mColor = color;
    mName = name;
    mIsAlive = true;
  }

  public String getName(){
    return mName;
  }

  public int getHunger() {
    return mHunger;
  }
  public int getHappiness() {
    return mHappiness;
  }
  public int getEnergy() {
    return mEnergy;
  }
  public int getDiscipline() {
    return mDiscipline;
  }

  public String getColor() {
    return mColor;
  }

  public void sleep(){
    mHunger = alterAttribute(mHunger, -5);
    if (mEnergy == 100) {
      mDiscipline = alterAttribute(mDiscipline, -50);
    }
    mEnergy = alterAttribute(mEnergy, 50);
  }

  public void feed(){
    mEnergy = alterAttribute(mEnergy, -10);
    if (mHunger == 100) {
      mDiscipline = alterAttribute(mDiscipline, -50);
    }
    mHunger = alterAttribute(mHunger, 30);
    mHappiness = alterAttribute(mHappiness, 10);
  }

  public void play(){
    mEnergy = alterAttribute(mEnergy, -25);
    mHunger = alterAttribute(mHunger, -25);
    if (mHappiness == 100) {
      mDiscipline = alterAttribute(mDiscipline, -50);
    }
    mHappiness = alterAttribute(mHappiness, 30);
  }

  public void exercise(){
    mHappiness = alterAttribute(mHappiness, -10);
    mEnergy = alterAttribute(mEnergy, -10);
    mDiscipline = alterAttribute(mDiscipline, 30);
  }

  public void discipline(){
    mHappiness = alterAttribute(mHappiness, -10);
    mDiscipline = alterAttribute(mDiscipline, 30);
  }

  public int alterAttribute(int stat, int amount) {
    stat += amount;
    if (stat > 100) {
      stat = 100;
    } else if (stat <= 0) {
      stat = 0;
      mIsAlive = false;
    }
    return stat;
  }
}
