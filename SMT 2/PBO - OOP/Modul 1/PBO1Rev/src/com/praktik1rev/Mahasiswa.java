 package com.praktik1rev;

    public class Mahasiswa {
        private String Name;

        private String Grade;
        private String Major;
        private String Faculty;
        private String NIM;

        //setter
        public void setName(String name) {
            Name = name;
        }
        public void setGrade(String grade) {
            Grade = grade;
        }
        public void setMajor(String major) {
            Major = major;
        }
        public void setFaculty(String faculty) {
            Faculty = faculty;
        }
        public void setNIM(String NIM) {
            this.NIM = NIM;
        }

        //getter
        public String getName() {
            return Name;
        }
        public String getGrade() {
            return Grade;
        }
        public String getMajor() {
            return Major;
        }
        public String getFaculty() {
            return Faculty;
        }
        public String getNIM() {
            return NIM;
        }

        public static void main(String[] args) {

            Mahasiswa objKu = new Mahasiswa();

            objKu.setName("Rizaldy Aristyo");
            objKu.setGrade("2J");
            objKu.setMajor("Informatika");
            objKu.setFaculty("Teknik");
            objKu.setNIM("202010370311440");

            System.out.println("Nama: " + objKu.getName());
            System.out.println("Kelas: " + objKu.getGrade());
            System.out.println("Jurusan: " + objKu.getMajor());
            System.out.println("Fakultas: " + objKu.getFaculty());
            System.out.println("NIM: " + objKu.getNIM());

            System.out.println();

        }
    }
