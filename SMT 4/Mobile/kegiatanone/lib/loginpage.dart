// ignore_for_file: prefer_const_constructors

import 'package:flutter/material.dart';
import 'package:kegiatantwo/accountpage.dart';

class Login extends StatelessWidget {
  const Login({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: AccountSwitcher());
  }
}
