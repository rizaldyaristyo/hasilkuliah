function render() {
  var gudang = localStorage.getItem("gudang");
  $("#tablenya").empty();
  $("#tablenya").append("<tr><th><a onclick=\"sortdis('title')\">Movie Title</a></th><th><a onclick=\"sortdis('rating')\">Movie Rating</a></th><th><a onclick=\"sortdis('id')\">Actions</a></th></tr>;");
  if (gudang) {
    var arrai = JSON.parse(gudang);
    arrai.forEach((element) => {
      $("#tablenya").append('<tr class="isi" data-id=' + element.id + ">\n<td>" + element.title + "</td>\n<td>" + element.rating + '</td>\n<td><button id="delete" onclick="deletdis(this)">Delete</button></td>\n</tr>');
    });
  }
}

$(document).ready(function () {
  render();
  $("#search").on("keyup", function () {
    var searchinput = $(this).val().toLowerCase();
    console.log(searchinput);
    $("#tablenya tr").filter(function () {
      $(this).toggle($(this).text().toLocaleLowerCase().indexOf(searchinput) > -1);
    });
  });
});

function addMovie() {
  var gudang = localStorage.getItem("gudang");
  if (gudang) {
    var arrai = JSON.parse(gudang);
    var databaru = {
      id: arrai.length + 1,
      title: $("#movieTitleEntry").val(),
      rating: parseInt($("#movieRatingEntry").val()),
    };
  } else {
    var arrai = [];
    var databaru = {
      id: 1,
      title: $("#movieTitleEntry").val(),
      rating: parseInt($("#movieRatingEntry").val()),
    };
  }
  arrai.push(databaru);
  localStorage.setItem("gudang", JSON.stringify(arrai));
  render();
  $("#movieTitleEntry").val("");
  $("#movieRatingEntry").val("");
}

function deletdis(konteks) {
  $(konteks).closest("tr").remove();
  console.log("Hapus: " + $(konteks).closest("tr").attr("data-id"));
  var gudang = localStorage.getItem("gudang");
  if (gudang) {
    var arrai = JSON.parse(gudang);
    var i = 0;
    while (i < arrai.length) {
      if (arrai[i].id == $(konteks).closest("tr").attr("data-id")) {
        arrai.splice(i, 1);
        break;
      } else i++;
    }
    localStorage.setItem("gudang", JSON.stringify(arrai));
  }
}

function sortdis(attribut) {
  var gudang = localStorage.getItem("gudang");
  if (gudang) {
    var arrai = JSON.parse(gudang);
    arrai.sort(function (a, b) {
      return a[attribut] > b[attribut] ? 1 : a[attribut] < b[attribut] ? -1 : 0;
    });
    localStorage.setItem("gudang", JSON.stringify(arrai));
  }
  render();
}
