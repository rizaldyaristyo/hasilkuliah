// ignore_for_file: avoid_print

import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'artikelsapi.dart';

bool? darkmode = true;
bool? loggedIn = false;
String? usernamenya = '';
Color? abuabu900 = Colors.grey[900];
Color? abuabu700 = Colors.grey[700];
Color? abuabu = Colors.grey;
Color? putih = Colors.white;
Color? hitam = Colors.white10;

String? token = '';
String? apiURL = "https://10.42.0.1";

Future<void> saveToLocal(String? usernamenya) async {
  final prefs = await SharedPreferences.getInstance();
  await prefs.setBool('darkmode', darkmode!);
  await prefs.setBool('loggedIn', loggedIn!);
  await prefs.setString('usernamenya', usernamenya!);
  print('Saving as ' + usernamenya);
}

deletePref() async {
  final prefs = await SharedPreferences.getInstance();
  await prefs.remove('darkmode');
  await prefs.remove('loggedIn');
  await prefs.remove('usernamenya');
  print('Prefs Deleted!');
}
