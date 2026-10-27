Studi Kasus: Sistem Pemrosesan Musik (Pop-Rock & Ballad-Rock)

1. Pendahuluan
Proyek ini adalah simulasi sistem pemrosesan aransemen musik yang berfokus pada lagu bergenre Pop-Rock dan Ballad-Rock. Kode ini dibuat untuk mengimplementasikan empat pilar utama Pemrograman Berorientasi Objek (OOP) dalam satu aplikasi Java yang sederhana dan saling terintegrasi.

2. Class Diagram

![Class Diagram](images/classdiagram.png)

3. Penjelasan Konsep Abstract dan Interface yang Diterapkan
Berikut adalah penjelasan detail mengenai konsep penting yang diimplementasikan di dalam kode:

A. Interface (PopStyle.java, RockStyle.java, BalladStyle.java) File-file ini bertindak sebagai kontrak untuk karakteristik dan gaya musik spesifik.
- Karena setiap genre musik memiliki elemen aransemen yang unik (seperti melodi piano pada Ballad, distorsi gitar pada Rock, dan synth hook pada Pop), digunakanlah interface.
- Pendekatan ini mengatasi keterbatasan single inheritance di Java, memungkinkan class seperti PopRock dan BalladRock untuk mengimplementasikan beberapa interface sekaligus (multiple inheritance via interface) dan melakukan override pada method spesifik tanpa merusak struktur utama.

B. Abstract Class (Music.java) File ini merupakan class induk yang bersifat abstrak.
- Class ini tidak bisa diinstansiasi secara langsung karena sebuah objek "Music" masih terlalu umum dan belum memiliki bentuk subgenre yang spesifik.
- Class ini menyimpan atribut dasar (seperti title, artist, dan durationInSeconds) serta dua abstract method yaitu performClimax() dan displayTrackDetails(). Method ini wajib di-override oleh child class untuk menampilkan detail dan klimaks aransemen yang sesuai dengan jenis lagunya.

C. Inheritance (Pewarisan) Class PopRock.java dan BalladRock.java adalah child class yang mewarisi sifat dari Music.java.
- Kedua class ini mengambil semua atribut dan fungsi dasar (seperti startPlayback() dan getDuration()) dari parent class.
- Selain itu, mereka menambahkan atribut uniknya masing-masing, seperti vocalCharacter (misalnya "Emotional Belting") dan leadInstrument (misalnya "Electric Guitar & Grand Piano").

D. Polymorphism (Banyak Bentuk) Polimorfisme memungkinkan kita menggunakan satu tipe referensi untuk menyimpan berbagai bentuk objek yang berbeda. Dalam file Main.java, konsep ini diterapkan melalui dua cara:
1. Melalui Interface: Variabel bertipe interface (seperti RockStyle) dapat menyimpan objek PopRock maupun BalladRock untuk memanggil method aransemen musik yang relevan.
2. Melalui Abstract Class: Variabel dengan tipe parent Music (misalnya dalam array Music[]) dapat menampung instance dari PopRock maupun BalladRock. Saat runtime, Java akan secara otomatis memanggil method performClimax() dan displayTrackDetails() yang tepat sesuai dengan tipe objek aslinya (apakah itu lagu Pop-Rock atau Ballad-Rock).