package azotzot.main;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CheckedOutputStream;

public class ComplexNumber {

    private double real = 0;
    private double img = 0;

    public ComplexNumber(double rl, double im) {
        real = rl;
        img = im;
    }

    public ComplexNumber(@NotNull ComplexNumber number) {
        real = number.real;
        img = number.img;
    }

    public ComplexNumber(String number) {
        if (number == null) {
            real = 0;
            img = 0;
        }else {
            double[] list = parse(number);
            real = list[0];
            img = list[1];
        }
    }

    public ComplexNumber plus(@NotNull ComplexNumber number) {
        this.real += number.real;
        this.img += number.img;
        return this;
    }

    public ComplexNumber minus(@NotNull ComplexNumber number) {
        this.real -= number.real;
        this.img -= number.img;
        return this;
    }

    public ComplexNumber mul(@NotNull ComplexNumber number) {
        return new ComplexNumber(real * number.real - img * number.img, real * number.img + img * number.real);
    }

    public ComplexNumber divided(@NotNull ComplexNumber number) {
        double t = Math.pow(number.real,2)+Math.pow(number.img,2);
        double a = (real * number.real + img * number.img);
        double b = (number.real * img - real * number.img);
        return new ComplexNumber(a/t,b/t);
    }

    public double abs() {
        return Math.hypot(real,img);
    }

    public ComplexNumber sin() {
        return new ComplexNumber(Math.sin(real) * Math.cosh(img), Math.cos(real) * Math.sinh(img));
    }

    public ComplexNumber cos() {
        return new ComplexNumber(Math.cos(real) * Math.cosh(img), -Math.sin(real) * Math.sinh(img));
    }

    public ComplexNumber conjugation(){
        if (img < 0)
            return new ComplexNumber(real, -img);
        else
            return new ComplexNumber(real, -img);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    @NotNull
    private double[] parse(@NotNull String number) {
        double[] list = new double[2];
        String tmp = number.trim();
        tmp = getComplex(tmp);
        if (!tmp.isEmpty()) {
            List<String> arr = parseComplex(tmp);
            list[0] = Double.parseDouble(arr.get(0));
            list[1] = Double.parseDouble(arr.get(1));
        } else {
            throw new NumberFormatException("Not a complex number");
        }
        return list;
    }

    private String getComplex(String number) {
        String regex = "(^[+-]?\\d+\\.?\\d*[+-]?\\d+\\.?\\d*i)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()) {
            return matcher.group();
        } else return "";

    }

    @NotNull
    private List<String> parseComplex(String number) {
        String regex = "([+-]?\\d+\\.?\\d*)";
//        String regex = "([+|-]?\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        List<String> arr = new ArrayList<>();
        while (matcher.find()) {
            arr.add(matcher.group());
        }
        return arr;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ComplexNumber number = (ComplexNumber) obj;
        return Math.abs(real - number.real) <= 10e-7 && Math.abs(img - number.img) <= 10e-7;
    }

    public String toString() {
        return real + " " + img + "i";
    }
}