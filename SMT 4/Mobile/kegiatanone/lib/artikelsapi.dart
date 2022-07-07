// To parse this JSON data, do
//
//     final welcome = welcomeFromJson(jsonString);

// import 'dart:_http';
import 'dart:convert';
import 'package:dio/dio.dart';
import 'preferences.dart';
// import 'package:http/http.dart' as http;

Welcome welcomeFromJson(String str) => Welcome.fromJson(json.decode(str));

// List<Welcome> welcomeListFromJson(List data){
//   return List<Welcome>.from(data.map((item) => Welcome.fromJson(item)));
// }

String welcomeToJson(Welcome data) => json.encode(data.toJson());

class Welcome {
  Welcome({
    required this.total,
    required this.message,
    required this.data,
  });

  int total;
  String message;
  List<Datum> data;

  factory Welcome.fromJson(Map<String, dynamic> json) => Welcome(
        total: json["total"],
        message: json["message"],
        data: List<Datum>.from(json["data"].map((x) => Datum.fromJson(x))),
      );

  Map<String, dynamic> toJson() => {
        "total": total,
        "message": message,
        "data": List<dynamic>.from(data.map((x) => x.toJson())),
      };
}

class Datum {
  Datum({
    required this.id,
    required this.image,
    required this.judul,
    required this.isiKonten,
    required this.createdAt,
    required this.updatedAt,
    required this.authorId,
    required this.categoryId,
  });

  int id;
  String image;
  String judul;
  String isiKonten;
  DateTime createdAt;
  DateTime updatedAt;
  int authorId;
  int categoryId;

  factory Datum.fromJson(Map<String, dynamic> json) => Datum(
        id: json["id"],
        image: json["image"],
        judul: json["judul"],
        isiKonten: json["isi_konten"],
        createdAt: DateTime.parse(json["created_at"]),
        updatedAt: DateTime.parse(json["updated_at"]),
        authorId: json["author_id"],
        categoryId: json["category_id"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "image": image,
        "judul": judul,
        "isi_konten": isiKonten,
        "created_at": createdAt.toIso8601String(),
        "updated_at": updatedAt.toIso8601String(),
        "author_id": authorId,
        "category_id": categoryId,
      };
}

Dio createDio(String baseUrl) {
  Dio dio = Dio(BaseOptions(
    headers: {"Content-Type": "application/json", "Cookie": "token="+token!},
    baseUrl: baseUrl,
    connectTimeout: 20000,
    receiveTimeout: 30000,
    sendTimeout: 20000,
    contentType: "application/json",
    responseType: ResponseType.json,
  ));
  return dio;
}

class ApiPathConstants {
  static const artikelsCRUDApi = "/api/v1/artikels";
  static const artikelsCRUDToken = "/api/v1/auth/login";
}

class Services {
  Dio _dio = createDio(apiURL!);

  // Get All Artikels (GET)
  Future<Map<String, dynamic>> artikelsCRUDApi() async {
    Response response = await _dio.get(ApiPathConstants.artikelsCRUDApi);
    return response.data;
  }

  // Create New Artikels (POST)
  Future<int> postArtikels({
    required String judul,
    required String isiKonten,
    required String image,
    required int authorId,
    required int categoryId,
  }) async {
    try {
      print('posting');
      final response = await _dio.post(
        ApiPathConstants.artikelsCRUDApi,
        data: {
          "judul": judul,
          "isi_konten": isiKonten,
          "image": image,
          "author_id": authorId,
          "category_id": categoryId,
        },
      );
      print(response.data);
      return response.statusCode ?? 404;
    } catch (e) {
      print(e);
      return 404;
    }
  }

  // Update Artikels (PATCH)
  Future<int> patchArtikels({
    required String id,
    required String judul,
    required String isiKonten,
    required String image,
    required String authorId,
    required String categoryId,
  }) async {
    try {
      final response = await _dio.patch(
        ApiPathConstants.artikelsCRUDApi + "/$id",
        data: {
          "judul": judul,
          "isi_konten": isiKonten,
          "image": image,
          "author_id": authorId,
          "category_id": categoryId,
        },
      );
      print(response.data);
      return response.statusCode ?? 404;
    } catch (e) {
      print(e);
      return 404;
    }
  }

  // Delete Artikels (DELETE)
  Future<int> deleteArtikels(String id) async {
    try {
      final response = await _dio.delete(ApiPathConstants.artikelsCRUDApi + "/" + id);
      print(response.data);
      return response.statusCode ?? 404;
    } catch (e) {
      print(e);
      return 404;
    }
  }

  // Get Token (POST)
  Future<String> getToken(String email, String password) async {
    try {
      final response = await _dio.post(
        ApiPathConstants.artikelsCRUDToken,
        data: {
          "email": email,
          "password": password,
        },
      );
      print(response.data["access_token"]);
      return response.data["access_token"];
    } catch (e) {
      print(e);
      return "ERROR";
    }
  }
}


