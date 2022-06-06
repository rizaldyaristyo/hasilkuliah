import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/foundation.dart';

class AuthenticationService {
  final FirebaseAuth _firebaseAuth;
  AuthenticationService(this._firebaseAuth);

  getUserData() {
    String userData = _firebaseAuth.currentUser.toString();
    debugPrint("DATA: " + userData);
    return userData;
  }

  getEmail() {
    var user = _firebaseAuth.currentUser;
    String? email = user?.email.toString();
    debugPrint("EMAIL: " + email!);
    return email;
  }

  Future<bool> signOut() async {
    try {
      await _firebaseAuth.signOut();
      return true;
    } on FirebaseAuthException catch (e) {
      debugPrint(e.message ?? "Error");
      return false;
    }
  }

  Future<bool> signIn({required String email, required String password}) async {
    try {
      await _firebaseAuth.signInWithEmailAndPassword(
          email: email, password: password);
      getUserData();
      return true;
    } on FirebaseAuthException catch (e) {
      debugPrint(e.message ?? "Error");
      return false;
    }
  }

  Future<bool> signUp({required String email, required String password}) async {
    try {
      await _firebaseAuth.createUserWithEmailAndPassword(
          email: email, password: password);
      return true;
    } on FirebaseAuthException catch (e) {
      debugPrint(e.message ?? "Error");
      return false;
    }
  }
}
