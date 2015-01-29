package entities.intelligence;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: CrimeScene
 * 
 */
@Entity
public class CrimeScene implements Serializable {

	private static final long serialVersionUID = 7288688344068326138L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CrimeSceneId;

	private boolean ForeignObjectPenetration;
	private boolean FaceNotDeliberatelyHidden;
	private boolean VictimWasBlindfolded;
	private boolean WoundsCausedByBluntInstrument;
	private boolean Suffocation; // (other than strangulation)
	private boolean VaginalPenetration;
	private boolean AnalPenetration;
	private boolean FaceUp; // (victim found as they fell)
	private boolean VictimPartiallyUndressed;
	private boolean VictimNaked;
	private boolean DeliberateClothingDamaged;
	private boolean Bound; // (at one point)
	private boolean StabbingInjuries;
	private boolean ManualInjuries; // (hitting, kicking, strangled)
	private boolean GunshotWounds;
	private boolean WoundsToTheHead;
	private boolean WoundsToTheFace;
	private boolean WoundsToTheNeck;
	private boolean WoundsToTheTorso;
	private boolean WoundsToTheLimbs;
	private boolean MultipleWoundsToOneBodyArea; // (MWOA)
	private boolean MultipleWoundsDistributedAcrossDifferentBodyParts; // (MWD)
	private boolean WeaponBroughtToScene;
	private boolean WeaponFromTheScene;
	private boolean IdentifiablePropertyStolen; // (identification property)
	private boolean NonidentifiablePropertyStolen; // nonvaluable unidentifiable
	private boolean ValuablePropertyStolen;
	private boolean BodyHidden; // (outside)
	private boolean BodyTransported;
	private boolean OffenderForensicallyAware;
	private boolean VictimFoundAtTheSameSceneWhereTheyWereKilled;
	private boolean SexualCrime;
	private boolean ArsonToCrimeSceneOrBody;
	private boolean VictimFoundInWater;
	private boolean VictimDruggedAndOrPoisoned;
	private boolean VictimCovered; // (i.e., inside rather than outside)



	public CrimeScene() {
		super();
	}



	public int getCrimeSceneId() {
		return CrimeSceneId;
	}



	public void setCrimeSceneId(int crimeSceneId) {
		CrimeSceneId = crimeSceneId;
	}



	public boolean isForeignObjectPenetration() {
		return ForeignObjectPenetration;
	}



	public void setForeignObjectPenetration(boolean foreignObjectPenetration) {
		ForeignObjectPenetration = foreignObjectPenetration;
	}



	public boolean isFaceNotDeliberatelyHidden() {
		return FaceNotDeliberatelyHidden;
	}



	public void setFaceNotDeliberatelyHidden(boolean faceNotDeliberatelyHidden) {
		FaceNotDeliberatelyHidden = faceNotDeliberatelyHidden;
	}



	public boolean isVictimWasBlindfolded() {
		return VictimWasBlindfolded;
	}



	public void setVictimWasBlindfolded(boolean victimWasBlindfolded) {
		VictimWasBlindfolded = victimWasBlindfolded;
	}



	public boolean isWoundsCausedByBluntInstrument() {
		return WoundsCausedByBluntInstrument;
	}



	public void setWoundsCausedByBluntInstrument(boolean woundsCausedByBluntInstrument) {
		WoundsCausedByBluntInstrument = woundsCausedByBluntInstrument;
	}



	public boolean isSuffocation() {
		return Suffocation;
	}



	public void setSuffocation(boolean suffocation) {
		Suffocation = suffocation;
	}



	public boolean isVaginalPenetration() {
		return VaginalPenetration;
	}



	public void setVaginalPenetration(boolean vaginalPenetration) {
		VaginalPenetration = vaginalPenetration;
	}



	public boolean isAnalPenetration() {
		return AnalPenetration;
	}



	public void setAnalPenetration(boolean analPenetration) {
		AnalPenetration = analPenetration;
	}



	public boolean isFaceUp() {
		return FaceUp;
	}



	public void setFaceUp(boolean faceUp) {
		FaceUp = faceUp;
	}



	public boolean isVictimPartiallyUndressed() {
		return VictimPartiallyUndressed;
	}



	public void setVictimPartiallyUndressed(boolean victimPartiallyUndressed) {
		VictimPartiallyUndressed = victimPartiallyUndressed;
	}



	public boolean isVictimNaked() {
		return VictimNaked;
	}



	public void setVictimNaked(boolean victimNaked) {
		VictimNaked = victimNaked;
	}



	public boolean isDeliberateClothingDamaged() {
		return DeliberateClothingDamaged;
	}



	public void setDeliberateClothingDamaged(boolean deliberateClothingDamaged) {
		DeliberateClothingDamaged = deliberateClothingDamaged;
	}



	public boolean isBound() {
		return Bound;
	}



	public void setBound(boolean bound) {
		Bound = bound;
	}



	public boolean isStabbingInjuries() {
		return StabbingInjuries;
	}



	public void setStabbingInjuries(boolean stabbingInjuries) {
		StabbingInjuries = stabbingInjuries;
	}



	public boolean isManualInjuries() {
		return ManualInjuries;
	}



	public void setManualInjuries(boolean manualInjuries) {
		ManualInjuries = manualInjuries;
	}



	public boolean isGunshotWounds() {
		return GunshotWounds;
	}



	public void setGunshotWounds(boolean gunshotWounds) {
		GunshotWounds = gunshotWounds;
	}



	public boolean isWoundsToTheHead() {
		return WoundsToTheHead;
	}



	public void setWoundsToTheHead(boolean woundsToTheHead) {
		WoundsToTheHead = woundsToTheHead;
	}



	public boolean isWoundsToTheFace() {
		return WoundsToTheFace;
	}



	public void setWoundsToTheFace(boolean woundsToTheFace) {
		WoundsToTheFace = woundsToTheFace;
	}



	public boolean isWoundsToTheNeck() {
		return WoundsToTheNeck;
	}



	public void setWoundsToTheNeck(boolean woundsToTheNeck) {
		WoundsToTheNeck = woundsToTheNeck;
	}



	public boolean isWoundsToTheTorso() {
		return WoundsToTheTorso;
	}



	public void setWoundsToTheTorso(boolean woundsToTheTorso) {
		WoundsToTheTorso = woundsToTheTorso;
	}



	public boolean isWoundsToTheLimbs() {
		return WoundsToTheLimbs;
	}



	public void setWoundsToTheLimbs(boolean woundsToTheLimbs) {
		WoundsToTheLimbs = woundsToTheLimbs;
	}



	public boolean isMultipleWoundsToOneBodyArea() {
		return MultipleWoundsToOneBodyArea;
	}



	public void setMultipleWoundsToOneBodyArea(boolean multipleWoundsToOneBodyArea) {
		MultipleWoundsToOneBodyArea = multipleWoundsToOneBodyArea;
	}



	public boolean isMultipleWoundsDistributedAcrossDifferentBodyParts() {
		return MultipleWoundsDistributedAcrossDifferentBodyParts;
	}



	public void setMultipleWoundsDistributedAcrossDifferentBodyParts(boolean multipleWoundsDistributedAcrossDifferentBodyParts) {
		MultipleWoundsDistributedAcrossDifferentBodyParts = multipleWoundsDistributedAcrossDifferentBodyParts;
	}



	public boolean isWeaponBroughtToScene() {
		return WeaponBroughtToScene;
	}



	public void setWeaponBroughtToScene(boolean weaponBroughtToScene) {
		WeaponBroughtToScene = weaponBroughtToScene;
	}



	public boolean isWeaponFromTheScene() {
		return WeaponFromTheScene;
	}



	public void setWeaponFromTheScene(boolean weaponFromTheScene) {
		WeaponFromTheScene = weaponFromTheScene;
	}



	public boolean isIdentifiablePropertyStolen() {
		return IdentifiablePropertyStolen;
	}



	public void setIdentifiablePropertyStolen(boolean identifiablePropertyStolen) {
		IdentifiablePropertyStolen = identifiablePropertyStolen;
	}



	public boolean isNonidentifiablePropertyStolen() {
		return NonidentifiablePropertyStolen;
	}



	public void setNonidentifiablePropertyStolen(boolean nonidentifiablePropertyStolen) {
		NonidentifiablePropertyStolen = nonidentifiablePropertyStolen;
	}



	public boolean isValuablePropertyStolen() {
		return ValuablePropertyStolen;
	}



	public void setValuablePropertyStolen(boolean valuablePropertyStolen) {
		ValuablePropertyStolen = valuablePropertyStolen;
	}



	public boolean isBodyHidden() {
		return BodyHidden;
	}



	public void setBodyHidden(boolean bodyHidden) {
		BodyHidden = bodyHidden;
	}



	public boolean isBodyTransported() {
		return BodyTransported;
	}



	public void setBodyTransported(boolean bodyTransported) {
		BodyTransported = bodyTransported;
	}



	public boolean isOffenderForensicallyAware() {
		return OffenderForensicallyAware;
	}



	public void setOffenderForensicallyAware(boolean offenderForensicallyAware) {
		OffenderForensicallyAware = offenderForensicallyAware;
	}



	public boolean isVictimFoundAtTheSameSceneWhereTheyWereKilled() {
		return VictimFoundAtTheSameSceneWhereTheyWereKilled;
	}



	public void setVictimFoundAtTheSameSceneWhereTheyWereKilled(boolean victimFoundAtTheSameSceneWhereTheyWereKilled) {
		VictimFoundAtTheSameSceneWhereTheyWereKilled = victimFoundAtTheSameSceneWhereTheyWereKilled;
	}



	public boolean isSexualCrime() {
		return SexualCrime;
	}



	public void setSexualCrime(boolean sexualCrime) {
		SexualCrime = sexualCrime;
	}



	public boolean isArsonToCrimeSceneOrBody() {
		return ArsonToCrimeSceneOrBody;
	}



	public void setArsonToCrimeSceneOrBody(boolean arsonToCrimeSceneOrBody) {
		ArsonToCrimeSceneOrBody = arsonToCrimeSceneOrBody;
	}



	public boolean isVictimFoundInWater() {
		return VictimFoundInWater;
	}



	public void setVictimFoundInWater(boolean victimFoundInWater) {
		VictimFoundInWater = victimFoundInWater;
	}



	public boolean isVictimDruggedAndOrPoisoned() {
		return VictimDruggedAndOrPoisoned;
	}



	public void setVictimDruggedAndOrPoisoned(boolean victimDruggedAndOrPoisoned) {
		VictimDruggedAndOrPoisoned = victimDruggedAndOrPoisoned;
	}



	public boolean isVictimCovered() {
		return VictimCovered;
	}



	public void setVictimCovered(boolean victimCovered) {
		VictimCovered = victimCovered;
	}

}
