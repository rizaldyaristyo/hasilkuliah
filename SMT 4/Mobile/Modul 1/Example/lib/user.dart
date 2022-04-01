class User {
  final String firstName;
  final String lastName;
  final String nim;
  final int? age;

  User({
    required this.nim,
    required this.firstName,
    required this.lastName,
    this.age,
  });

  String getFullName() {
    return firstName + '' + lastName;
  }

  String getNim() {
    return nim;
  }

  int getAge() {
    return age!;
  }
}
