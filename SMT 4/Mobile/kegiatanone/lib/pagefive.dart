// ignore_for_file: prefer_const_constructors

import 'package:flutter/material.dart';
import 'package:kegiatantwo/bottomnavbar.dart';

class PageFive extends StatefulWidget {
  const PageFive({Key? key}) : super(key: key);

  @override
  State<PageFive> createState() => _PageFiveState();
}

class _PageFiveState extends State<PageFive> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: SingleChildScrollView(
          child: Text("PAGE 5 UNDER CONSTRUCTION"),
        ),
        bottomNavigationBar: BottomNavBar(),
      ),
    );
  }
}
