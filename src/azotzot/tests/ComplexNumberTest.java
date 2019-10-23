package azotzot.tests;
import azotzot.main.ComplexNumber;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ComplexNumberTest {

    private final ComplexNumber complex1 = new ComplexNumber(10,-11);
    private final ComplexNumber complex2 = new ComplexNumber(17,4);
    private final ComplexNumber complex3 = new ComplexNumber(-4,5);
    private final ComplexNumber complex4 = new ComplexNumber(19,25);
    private final ComplexNumber complex5 = new ComplexNumber(-9,-15);

    @Test
    void ComplexNumber() {
        assertEquals(new ComplexNumber(10,-11), new ComplexNumber("10-11i"));
        assertEquals(new ComplexNumber(17,4), new ComplexNumber("17+4i"));
        assertEquals(new ComplexNumber(-4,5), new ComplexNumber("-4+5i"));
        assertEquals(new ComplexNumber(19,25), new ComplexNumber("19+25i"));
        assertEquals(new ComplexNumber(-9,-15), new ComplexNumber("-9-15i"));
        assertEquals(new ComplexNumber(-9.15,-15), new ComplexNumber("-9.15-15i"));
        assertEquals(new ComplexNumber(-9,-15.22), new ComplexNumber("-9-15.22i"));
        assertEquals(new ComplexNumber(-11.56,3.39), new ComplexNumber("-11.56+3.39i"));
    }

    @Test
    void plus() {
        assertEquals(new ComplexNumber(27,-7), complex1.plus(complex2));
        assertEquals(new ComplexNumber(13,9), complex2.plus(complex3));
        assertEquals(new ComplexNumber(15,30), complex3.plus(complex4));
        assertEquals(new ComplexNumber(10,10), complex4.plus(complex5));
    }

    @Test
    void minus() {
        assertEquals(new ComplexNumber(-7,-15), complex1.minus(complex2));
        assertEquals(new ComplexNumber(21,-1), complex2.minus(complex3));
        assertEquals(new ComplexNumber(-23,-20), complex3.minus(complex4));
        assertEquals(new ComplexNumber(28,40), complex4.minus(complex5));
    }

    @Test
    void mul() {
        assertEquals(new ComplexNumber(214,-147), complex1.mul(complex2));
        assertEquals(new ComplexNumber(-88,69), complex2.mul(complex3));
        assertEquals(new ComplexNumber(-201,-5), complex3.mul(complex4));
        assertEquals(new ComplexNumber(204,-510), complex4.mul(complex5));

    }

    @Test
    void divided() {
        assertEquals(new ComplexNumber(0.4131147540983607,-0.7442622950819672), complex1.divided(complex2));
        assertEquals(new ComplexNumber(-1.170731707317073, -2.4634146341463414), complex2.divided(complex3));
        assertEquals(new ComplexNumber(0.04969574036511156, 0.19776876267748478), complex3.divided(complex4));
        assertEquals(new ComplexNumber(-1.7843137254901962, 0.19607843137254902), complex4.divided(complex5));
    }

    @Test
    void abs() {
        assertEquals(Math.sqrt(221),complex1.abs(),10e-7);
        assertEquals(Math.sqrt(305),complex2.abs(),10e-7);
        assertEquals(Math.sqrt(41),complex3.abs(),10e-7);
        assertEquals(Math.sqrt(986),complex4.abs(),10e-7);
        assertEquals(Math.sqrt(306),complex5.abs(),10e-7);
    }

    @Test
    void sin() {
//        -16286.398549267776564155705701306911121159397914334365500... +
//25119.343813548659704774004291733224113042220197877347951... i
        assertEquals(new ComplexNumber(-16286.398549, 25119.343813), complex1.sin());
//        -26.254066556209208130565540134003684842182351428169725461... -
//                7.5091847111133521112990665861705236175251344488453517503... i
        assertEquals(new ComplexNumber(-26.254066, -7.509184), complex2.sin());
        //        56.1622742202323497046628697205879237038456407008599620062... -
//                48.5024552417709127724974953626411138889476599910674329229... i
        assertEquals(new ComplexNumber(56.1622742, -48.5024552), complex3.sin());
//        5.395946697374579849696308636667040947949771932783533... × 10^9 +
//                3.559578825346982648845741858104963111560613205844327... × 10^10 i
        assertEquals(new ComplexNumber(5.3959466973745798496963E9, 3.55957882534698264884E10), complex4.sin());
//        -673611.2438861597179324698920702192907373435954233994... +
//                1.489250327342897054574424425212846322683463782473682... × 10^6 i
        assertEquals(new ComplexNumber(-673611.2438861597179, 1.48925032734289705457E6), complex5.sin());


    }

    @Test
    void cos() {
        //    -25119.343827562581325022823919107483223237777385673224637... -
//            16286.398540181698746504396434002391350498328380955667491... i
        assertEquals(new ComplexNumber(-25119.343827, -16286.39854018), complex1.cos());
//-7.5142245034485238495385377580433608929757534334893477646... +
//26.236457946919407415685503929160317010648429482987217643... i
        assertEquals(new ComplexNumber(-7.514224, 26.236457), complex2.cos());
//-48.506859457844582105208548876985040195066125056469760745... -
//56.157174925130189256208625244083151069647966457023044769... i
        assertEquals(new ComplexNumber(-48.5068594578445, -56.1571749251301), complex3.cos());
//        3.559578825346982648847114965528603826327748834718104... × 10^10 -
//                5.395946697374579849694227150392604422916851515025712... × 10^9 i
        assertEquals(new ComplexNumber(3.5595788253469826488E10, -5.395946697374579E9), complex4.cos());
//        -1.489250327343175771435814384138018187656897492633036... × 10^6 -
//673611.2438860336499315127412908967006957304769195279... i
        assertEquals(new ComplexNumber(-1.489250327343175771435E6, -673611.2438860336499), complex5.cos());
    }

    @Test
    void conjugation() {
        assertEquals(new ComplexNumber(10, 11), complex1.conjugation());
        assertEquals(new ComplexNumber(17, -4), complex2.conjugation());
        assertEquals(new ComplexNumber(-4,-5), complex3.conjugation());
        assertEquals(new ComplexNumber(19,-25), complex4.conjugation());
        assertEquals(new ComplexNumber(-9,15), complex5.conjugation());
    }
}