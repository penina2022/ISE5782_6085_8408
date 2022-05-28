package primitives;

/**
 * Class represents the material of a Geometry
 */
public class Material {
    // Field represents the
    public Double3 kD = Double3.ZERO;
    // Field represents the
    public Double3 kS = Double3.ZERO;
    // Field represents the shininess of the material
    public int nShininess = 0;
    /**
     * for transparency
     */
    public Double3 kT=Double3.ZERO;
    /**
     * for reflection
     */
    public Double3 kR=Double3.ZERO;

    /**
     * Builder patterns setter for field kD
     * @param kD parameter for kD
     * @return Material object
     */
    public Material setKd(Double3 kD) {
        this.kD = kD;
        return this;
    }

    /**
     * Builder patterns setter for field kt
     * @param kt parameter for kt
     * @return Material object
     */
    public Material setKT(Double3 kt) {
        this.kT = kt;
        return this;
    }

    /**
     * Builder patterns setter for field kR
     * @param kR parameter for kR
     * @return Material object
     */
    public Material setkR(Double3 kR) {
        this.kR = kR;
        return this;
    }

    /**
     * Builder patterns setter for field kD
     * @param value parameter for kD constructor
     * @return Material object
     */
    public Material setKd(double value) {
        this.kD = new Double3(value);
        return this;
    }

    /**
     * Builder patterns setter for field kS
     * @param kS parameter for kS
     * @return Material object
     */
    public Material setKs(Double3 kS) {
        this.kS = kS;
        return this;
    }

    /**
     * Builder patterns setter for field kS
     * @param value parameter for kS constructor
     * @return Material object
     */
    public Material setKs(double value) {
        this.kS = new Double3(value);
        return this;
    }

    /**
     * Builder patterns setter for field nShininess
     * @param nShininess parameter for nShininess
     * @return Material object
     */
    public Material setShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }


    /**
     * Builder patterns setter for field kT
     * @param value parameter for kT constructor
     * @return Material object
     */
    public Material setKT(double value) {
        this.kT = new Double3(value);
        return this;
    }

    /**
     * Builder patterns setter for field kR
     * @param kR parameter for kR
     * @return Material object
     */
    public Material setKR(Double3 kR) {
        this.kR = kR;
        return this;
    }

    /**
     * Builder patterns setter for field kR
     * @param value parameter for kR constructor
     * @return Material object
     */
    public Material setKR(double value) {
        this.kR = new Double3(value);
        return this;
    }


}
