#include <iostream>
using namespace std;

#define phi 3.14
#define maxsize 255
#define rootdir 'C'
#define min_kelvin 80.0
#define R 8.314472

int main(){
	int jumlah = 0;
	char jawaban = 'B';
	double suhu_awal = 25.0;
	float radius = 0.0;
	double harga = 10000.00;
	int nilai_hexa = 0x1A;
	int nilai_oktal = 022;
	
	cout << "Nilai Jumlah: " << jumlah << endl;
	cout << "Nilai Jawaban: " << jawaban << endl;
	cout << "Nilai Suhu Awal: " << suhu_awal << endl;
	cout << "Nilai Radius: " << radius << endl;
	cout << "Nilai Harga: " << harga << endl;
	cout << "Nilai Nillai Hexa: " << nilai_hexa << endl;
	cout << "Nilai Nilai Oktal: " << nilai_oktal << endl;
	cout << "Nilai Phi: " << phi << endl;
	cout << "Nilai Maxsize: " << maxsize << endl;
	cout << "Nilai Rootdir: " << rootdir << endl;
	cout << "Nilai Min Kelvin: " << min_kelvin << endl;
	cout << "Nilai R: " << R << endl;
	
	return 0;
}