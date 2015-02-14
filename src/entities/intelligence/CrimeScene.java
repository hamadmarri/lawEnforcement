package entities.intelligence;

import java.io.Serializable;

import javax.persistence.*;

import entities.police.InvestigativeCase;


/**
 * Entity implementation class for Entity: CrimeScene
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "CrimeScene.findAll", query = "select c from CrimeScene c"),
		@NamedQuery(name = "CrimeScene.findById", query = "select c from CrimeScene c WHERE c.crimeSceneId = :id") })
public class CrimeScene implements Serializable {

	private static final long serialVersionUID = 7288688344068326138L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long crimeSceneId;

	private boolean foreignObjectPenetration;
	private boolean faceNotDeliberatelyHidden;
	private boolean victimWasBlindfolded;
	private boolean woundsCausedByBluntInstrument;
	private boolean suffocation; // (other than strangulation)
	private boolean vaginalPenetration;
	private boolean analPenetration;
	private boolean faceUp; // (victim found as they fell)
	private boolean victimPartiallyUndressed;
	private boolean victimNaked;
	private boolean deliberateClothingDamaged;
	private boolean bound; // (at one point)
	private boolean stabbingInjuries;
	private boolean manualInjuries; // (hitting, kicking, strangled)
	private boolean gunshotWounds;
	private boolean woundsToTheHead;
	private boolean woundsToTheFace;
	private boolean woundsToTheNeck;
	private boolean woundsToTheTorso;
	private boolean woundsToTheLimbs;
	private boolean multipleWoundsToOneBodyArea; // (MWOA)
	private boolean multipleWoundsDistributedAcrossDifferentBodyParts; // (MWD)
	private boolean weaponBroughtToScene;
	private boolean weaponFromTheScene;
	private boolean identifiablePropertyStolen; // (identification property)
	private boolean nonidentifiablePropertyStolen; // nonvaluable unidentifiable
	private boolean valuablePropertyStolen;
	private boolean bodyHidden; // (outside)
	private boolean bodyTransported;
	private boolean offenderForensicallyAware;
	private boolean victimFoundAtTheSameSceneWhereTheyWereKilled;
	private boolean sexualCrime;
	private boolean arsonToCrimeSceneOrBody;
	private boolean victimFoundInWater;
	private boolean victimDruggedAndOrPoisoned;
	private boolean victimCovered; // (i.e., inside rather than outside)

	@OneToOne(mappedBy = "crimeScene")
	private InvestigativeCase investigativeCase;

	@OneToOne(cascade = CascadeType.ALL)
	private OffenderProfile offenderProfile;



	public CrimeScene() {
		super();
		this.foreignObjectPenetration = false;
		this.faceNotDeliberatelyHidden = false;
		this.victimWasBlindfolded = false;
		this.woundsCausedByBluntInstrument = false;
		this.suffocation = false;
		this.vaginalPenetration = false;
		this.analPenetration = false;
		this.faceUp = false;
		this.victimPartiallyUndressed = false;
		this.victimNaked = false;
		this.deliberateClothingDamaged = false;
		this.bound = false;
		this.stabbingInjuries = false;
		this.manualInjuries = false;
		this.gunshotWounds = false;
		this.woundsToTheHead = false;
		this.woundsToTheFace = false;
		this.woundsToTheNeck = false;
		this.woundsToTheTorso = false;
		this.woundsToTheLimbs = false;
		this.multipleWoundsToOneBodyArea = false;
		this.multipleWoundsDistributedAcrossDifferentBodyParts = false;
		this.weaponBroughtToScene = false;
		this.weaponFromTheScene = false;
		this.identifiablePropertyStolen = false;
		this.nonidentifiablePropertyStolen = false;
		this.valuablePropertyStolen = false;
		this.bodyHidden = false;
		this.bodyTransported = false;
		this.offenderForensicallyAware = false;
		this.victimFoundAtTheSameSceneWhereTheyWereKilled = false;
		this.sexualCrime = false;
		this.arsonToCrimeSceneOrBody = false;
		this.victimFoundInWater = false;
		this.victimDruggedAndOrPoisoned = false;
		this.victimCovered = false;
	}



	public CrimeScene(boolean foreignObjectPenetration, boolean faceNotDeliberatelyHidden,
			boolean victimWasBlindfolded, boolean woundsCausedByBluntInstrument, boolean suffocation,
			boolean vaginalPenetration, boolean analPenetration, boolean faceUp, boolean victimPartiallyUndressed,
			boolean victimNaked, boolean deliberateClothingDamaged, boolean bound, boolean stabbingInjuries,
			boolean manualInjuries, boolean gunshotWounds, boolean woundsToTheHead, boolean woundsToTheFace,
			boolean woundsToTheNeck, boolean woundsToTheTorso, boolean woundsToTheLimbs,
			boolean multipleWoundsToOneBodyArea, boolean multipleWoundsDistributedAcrossDifferentBodyParts,
			boolean weaponBroughtToScene, boolean weaponFromTheScene, boolean identifiablePropertyStolen,
			boolean nonidentifiablePropertyStolen, boolean valuablePropertyStolen, boolean bodyHidden,
			boolean bodyTransported, boolean offenderForensicallyAware,
			boolean victimFoundAtTheSameSceneWhereTheyWereKilled, boolean sexualCrime, boolean arsonToCrimeSceneOrBody,
			boolean victimFoundInWater, boolean victimDruggedAndOrPoisoned, boolean victimCovered) {
		super();
		this.foreignObjectPenetration = foreignObjectPenetration;
		this.faceNotDeliberatelyHidden = faceNotDeliberatelyHidden;
		this.victimWasBlindfolded = victimWasBlindfolded;
		this.woundsCausedByBluntInstrument = woundsCausedByBluntInstrument;
		this.suffocation = suffocation;
		this.vaginalPenetration = vaginalPenetration;
		this.analPenetration = analPenetration;
		this.faceUp = faceUp;
		this.victimPartiallyUndressed = victimPartiallyUndressed;
		this.victimNaked = victimNaked;
		this.deliberateClothingDamaged = deliberateClothingDamaged;
		this.bound = bound;
		this.stabbingInjuries = stabbingInjuries;
		this.manualInjuries = manualInjuries;
		this.gunshotWounds = gunshotWounds;
		this.woundsToTheHead = woundsToTheHead;
		this.woundsToTheFace = woundsToTheFace;
		this.woundsToTheNeck = woundsToTheNeck;
		this.woundsToTheTorso = woundsToTheTorso;
		this.woundsToTheLimbs = woundsToTheLimbs;
		this.multipleWoundsToOneBodyArea = multipleWoundsToOneBodyArea;
		this.multipleWoundsDistributedAcrossDifferentBodyParts = multipleWoundsDistributedAcrossDifferentBodyParts;
		this.weaponBroughtToScene = weaponBroughtToScene;
		this.weaponFromTheScene = weaponFromTheScene;
		this.identifiablePropertyStolen = identifiablePropertyStolen;
		this.nonidentifiablePropertyStolen = nonidentifiablePropertyStolen;
		this.valuablePropertyStolen = valuablePropertyStolen;
		this.bodyHidden = bodyHidden;
		this.bodyTransported = bodyTransported;
		this.offenderForensicallyAware = offenderForensicallyAware;
		this.victimFoundAtTheSameSceneWhereTheyWereKilled = victimFoundAtTheSameSceneWhereTheyWereKilled;
		this.sexualCrime = sexualCrime;
		this.arsonToCrimeSceneOrBody = arsonToCrimeSceneOrBody;
		this.victimFoundInWater = victimFoundInWater;
		this.victimDruggedAndOrPoisoned = victimDruggedAndOrPoisoned;
		this.victimCovered = victimCovered;
	}



	public Long getCrimeSceneId() {
		return crimeSceneId;
	}



	public void setCrimeSceneId(Long crimeSceneId) {
		this.crimeSceneId = crimeSceneId;
	}



	public boolean getForeignObjectPenetration() {
		return foreignObjectPenetration;
	}



	public void setForeignObjectPenetration(boolean foreignObjectPenetration) {
		this.foreignObjectPenetration = foreignObjectPenetration;
	}



	public boolean getFaceNotDeliberatelyHidden() {
		return faceNotDeliberatelyHidden;
	}



	public void setFaceNotDeliberatelyHidden(boolean faceNotDeliberatelyHidden) {
		this.faceNotDeliberatelyHidden = faceNotDeliberatelyHidden;
	}



	public boolean getVictimWasBlindfolded() {
		return victimWasBlindfolded;
	}



	public void setVictimWasBlindfolded(boolean victimWasBlindfolded) {
		this.victimWasBlindfolded = victimWasBlindfolded;
	}



	public boolean getWoundsCausedByBluntInstrument() {
		return woundsCausedByBluntInstrument;
	}



	public void setWoundsCausedByBluntInstrument(boolean woundsCausedByBluntInstrument) {
		this.woundsCausedByBluntInstrument = woundsCausedByBluntInstrument;
	}



	public boolean getSuffocation() {
		return suffocation;
	}



	public void setSuffocation(boolean suffocation) {
		this.suffocation = suffocation;
	}



	public boolean getVaginalPenetration() {
		return vaginalPenetration;
	}



	public void setVaginalPenetration(boolean vaginalPenetration) {
		this.vaginalPenetration = vaginalPenetration;
	}



	public boolean getAnalPenetration() {
		return analPenetration;
	}



	public void setAnalPenetration(boolean analPenetration) {
		this.analPenetration = analPenetration;
	}



	public boolean getFaceUp() {
		return faceUp;
	}



	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}



	public boolean getVictimPartiallyUndressed() {
		return victimPartiallyUndressed;
	}



	public void setVictimPartiallyUndressed(boolean victimPartiallyUndressed) {
		this.victimPartiallyUndressed = victimPartiallyUndressed;
	}



	public boolean getVictimNaked() {
		return victimNaked;
	}



	public void setVictimNaked(boolean victimNaked) {
		this.victimNaked = victimNaked;
	}



	public boolean getDeliberateClothingDamaged() {
		return deliberateClothingDamaged;
	}



	public void setDeliberateClothingDamaged(boolean deliberateClothingDamaged) {
		this.deliberateClothingDamaged = deliberateClothingDamaged;
	}



	public boolean getBound() {
		return bound;
	}



	public void setBound(boolean bound) {
		this.bound = bound;
	}



	public boolean getStabbingInjuries() {
		return stabbingInjuries;
	}



	public void setStabbingInjuries(boolean stabbingInjuries) {
		this.stabbingInjuries = stabbingInjuries;
	}



	public boolean getManualInjuries() {
		return manualInjuries;
	}



	public void setManualInjuries(boolean manualInjuries) {
		this.manualInjuries = manualInjuries;
	}



	public boolean getGunshotWounds() {
		return gunshotWounds;
	}



	public void setGunshotWounds(boolean gunshotWounds) {
		this.gunshotWounds = gunshotWounds;
	}



	public boolean getWoundsToTheHead() {
		return woundsToTheHead;
	}



	public void setWoundsToTheHead(boolean woundsToTheHead) {
		this.woundsToTheHead = woundsToTheHead;
	}



	public boolean getWoundsToTheFace() {
		return woundsToTheFace;
	}



	public void setWoundsToTheFace(boolean woundsToTheFace) {
		this.woundsToTheFace = woundsToTheFace;
	}



	public boolean getWoundsToTheNeck() {
		return woundsToTheNeck;
	}



	public void setWoundsToTheNeck(boolean woundsToTheNeck) {
		this.woundsToTheNeck = woundsToTheNeck;
	}



	public boolean getWoundsToTheTorso() {
		return woundsToTheTorso;
	}



	public void setWoundsToTheTorso(boolean woundsToTheTorso) {
		this.woundsToTheTorso = woundsToTheTorso;
	}



	public boolean getWoundsToTheLimbs() {
		return woundsToTheLimbs;
	}



	public void setWoundsToTheLimbs(boolean woundsToTheLimbs) {
		this.woundsToTheLimbs = woundsToTheLimbs;
	}



	public boolean getMultipleWoundsToOneBodyArea() {
		return multipleWoundsToOneBodyArea;
	}



	public void setMultipleWoundsToOneBodyArea(boolean multipleWoundsToOneBodyArea) {
		this.multipleWoundsToOneBodyArea = multipleWoundsToOneBodyArea;
	}



	public boolean getMultipleWoundsDistributedAcrossDifferentBodyParts() {
		return multipleWoundsDistributedAcrossDifferentBodyParts;
	}



	public void setMultipleWoundsDistributedAcrossDifferentBodyParts(
			boolean multipleWoundsDistributedAcrossDifferentBodyParts) {
		this.multipleWoundsDistributedAcrossDifferentBodyParts = multipleWoundsDistributedAcrossDifferentBodyParts;
	}



	public boolean getWeaponBroughtToScene() {
		return weaponBroughtToScene;
	}



	public void setWeaponBroughtToScene(boolean weaponBroughtToScene) {
		this.weaponBroughtToScene = weaponBroughtToScene;
	}



	public boolean getWeaponFromTheScene() {
		return weaponFromTheScene;
	}



	public void setWeaponFromTheScene(boolean weaponFromTheScene) {
		this.weaponFromTheScene = weaponFromTheScene;
	}



	public boolean getIdentifiablePropertyStolen() {
		return identifiablePropertyStolen;
	}



	public void setIdentifiablePropertyStolen(boolean identifiablePropertyStolen) {
		this.identifiablePropertyStolen = identifiablePropertyStolen;
	}



	public boolean getNonidentifiablePropertyStolen() {
		return nonidentifiablePropertyStolen;
	}



	public void setNonidentifiablePropertyStolen(boolean nonidentifiablePropertyStolen) {
		this.nonidentifiablePropertyStolen = nonidentifiablePropertyStolen;
	}



	public boolean getValuablePropertyStolen() {
		return valuablePropertyStolen;
	}



	public void setValuablePropertyStolen(boolean valuablePropertyStolen) {
		this.valuablePropertyStolen = valuablePropertyStolen;
	}



	public boolean getBodyHidden() {
		return bodyHidden;
	}



	public void setBodyHidden(boolean bodyHidden) {
		this.bodyHidden = bodyHidden;
	}



	public boolean getBodyTransported() {
		return bodyTransported;
	}



	public void setBodyTransported(boolean bodyTransported) {
		this.bodyTransported = bodyTransported;
	}



	public boolean getOffenderForensicallyAware() {
		return offenderForensicallyAware;
	}



	public void setOffenderForensicallyAware(boolean offenderForensicallyAware) {
		this.offenderForensicallyAware = offenderForensicallyAware;
	}



	public boolean getVictimFoundAtTheSameSceneWhereTheyWereKilled() {
		return victimFoundAtTheSameSceneWhereTheyWereKilled;
	}



	public void setVictimFoundAtTheSameSceneWhereTheyWereKilled(boolean victimFoundAtTheSameSceneWhereTheyWereKilled) {
		this.victimFoundAtTheSameSceneWhereTheyWereKilled = victimFoundAtTheSameSceneWhereTheyWereKilled;
	}



	public boolean getSexualCrime() {
		return sexualCrime;
	}



	public void setSexualCrime(boolean sexualCrime) {
		this.sexualCrime = sexualCrime;
	}



	public boolean getArsonToCrimeSceneOrBody() {
		return arsonToCrimeSceneOrBody;
	}



	public void setArsonToCrimeSceneOrBody(boolean arsonToCrimeSceneOrBody) {
		this.arsonToCrimeSceneOrBody = arsonToCrimeSceneOrBody;
	}



	public boolean getVictimFoundInWater() {
		return victimFoundInWater;
	}



	public void setVictimFoundInWater(boolean victimFoundInWater) {
		this.victimFoundInWater = victimFoundInWater;
	}



	public boolean getVictimDruggedAndOrPoisoned() {
		return victimDruggedAndOrPoisoned;
	}



	public void setVictimDruggedAndOrPoisoned(boolean victimDruggedAndOrPoisoned) {
		this.victimDruggedAndOrPoisoned = victimDruggedAndOrPoisoned;
	}



	public boolean getVictimCovered() {
		return victimCovered;
	}



	public void setVictimCovered(boolean victimCovered) {
		this.victimCovered = victimCovered;
	}



	public OffenderProfile getOffenderProfile() {
		return offenderProfile;
	}



	public void setOffenderProfile(OffenderProfile offenderProfile) {
		this.offenderProfile = offenderProfile;
	}



	public InvestigativeCase getInvestigativeCase() {
		return investigativeCase;
	}



	public void setInvestigativeCase(InvestigativeCase investigativeCase) {
		this.investigativeCase = investigativeCase;
	}

}
