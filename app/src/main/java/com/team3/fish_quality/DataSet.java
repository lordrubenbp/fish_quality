package com.team3.fish_quality;

public  class DataSet
{
    public static String kindExplotation ="";
    public static String kindSpecies="";
    public static int production=0;
    public static float feedPercentageCereals=0f;
    public static float feedPercentageFish=0f;
    public static float feedPercentageOthers=0f;

    public static float latitude=0f;
    public static float longitude=0f;
    public static float[] monthlyAverageTemp = {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
    public static float[] monthlyAverageSolarPower = {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};

    public static String HHReport;
    public static float HH;
    public static float Q;  // m^3 / año
    public static float Qmax;   // m^3 / año
    public static float Qent;   // m^3 / año
    public static float consumoCereal;  // m^3 / año
    public static final float entradaAguaPorLubina = 4.5f;    // m^3 / Kg
    public static final float aguaEnCereal = 0.5f;    // m^3 / Kg
    public static float malimento;  // Kg / año
    public static final float factorAlimentacionLubina = 4.5f;
    public static float R;
    public static float consumoCerealPrime;   // m^3 / año
    public static float masaAlgas;    // Kg / año
    public static final float productividadAlgas = 100f;   //   g / m^3 / dia

    public static void calculateHH()
    {
        Qent = production * entradaAguaPorLubina;
        masaAlgas = productividadAlgas * Qent * 0.365f;
        consumoCerealPrime = (malimento - masaAlgas) * feedPercentageCereals * aguaEnCereal;
        Q = Qent * (1.0f - R) + consumoCerealPrime;
        malimento = production * factorAlimentacionLubina;
        consumoCereal = malimento * feedPercentageCereals * aguaEnCereal;
        Qmax = Qent + consumoCereal;
        HH = Q / Qmax;
    }
}
