/* PASTIKAN NAMA PACKAGE INI SAMA KAYAK FILE LAINNYA 
   (Cek baris paling atas di FormPegawai.java lu)
*/
package com.mycompany.projekpbo; 

public class ItemCombo {
    private String key;   // Ini buat nyimpen ID (misal: "1")
    private String value; // Ini buat nyimpen Nama (misal: "Keuangan")

    // Constructor
    public ItemCombo(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // Buat ambil ID
    public String getKey() {
        return key;
    }

    // Buat ambil Nama
    public String getValue() {
        return value;
    }

    // Ini fungsi AJAIB biar pas ComboBox dibuka, yang muncul NAMANYA doang
    @Override
    public String toString() {
        return value;
    }
}