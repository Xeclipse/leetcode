package general;

/**
 * @Author: Alex.Z
 * @DATE: 2019/1/28
 * @Description:
 */
public class Fraction {

    private long Numerator; // 分子
    private long Denominator; // 分母

    public Fraction(long numerator, long denominator) {
        this.Numerator = numerator;
        if (denominator == 0) {
            throw new ArithmeticException("分母不能为零");
        } else {
            this.Denominator = denominator;
        }
        change();
    }

    public Fraction() {
        this(0, 1);
    }

    public long getNumerator() {
        return Numerator;
    }

    public void setNumerator(long numerator) {
        Numerator = numerator;
    }

    public long getDenominator() {
        return Denominator;
    }

    public void setDenominator(long denominator) {
        Denominator = denominator;
    }

    private Fraction change() {
        long gcd = this.gcd(this.Numerator, this.Denominator);
        this.Numerator /= gcd;
        this.Denominator /= gcd;
        return this;
    }

    /**
     * 最大公因数
     *
     * @param a
     * @param b
     * @return
     */
    private long gcd(long a, long b) {
        long mod = a % b;
        if (mod == 0) {
            return b;
        } else {
            return gcd(b, mod);
        }
    }

    /**
     * 四则运算
     * @return
     */
    public Fraction add(Fraction second) {
        return new Fraction(this.Numerator * second.Denominator + second.Numerator * this.Denominator,
                this.Denominator * second.Denominator);
    }

    public Fraction sub(Fraction second) {
        return new Fraction(this.Numerator * second.Denominator - second.Numerator * this.Denominator,
                this.Denominator * second.Denominator);
    }

    public Fraction multiply(Fraction second) {
        return new Fraction(this.Numerator*second.Numerator,
                this.Denominator * second.Denominator);
    }

    public Fraction devide(Fraction second) {
        return new Fraction(this.Numerator*second.Denominator,
                this.Denominator * second.Numerator);
    }

    @Override
    public String toString() {
        return String.format("{%d/%d}", this.Numerator, this.Denominator);
    }
    public static void main(String[] args) {
        Fraction a = new Fraction(7, 32);
        Fraction b = new Fraction(13, 32);
        System.out.println(a.add(b));
    }
}
