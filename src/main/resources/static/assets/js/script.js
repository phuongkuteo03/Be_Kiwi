// Ẩn sidebar
document.addEventListener("DOMContentLoaded", function () {
  var menuToggle = document.getElementById("menu-toggle");
  var sidebarWrapper = document.getElementById("sidebar-wrapper");

  menuToggle.addEventListener("click", function () {
    sidebarWrapper.classList.toggle("toggled");
    var pageContentWrapper = document.getElementById("page-content-wrapper");
    pageContentWrapper.classList.toggle("expanded");
  });
});

// Hộp thoại gợi ý tìm kiếm
document.addEventListener("DOMContentLoaded", () => {
  const searchInput = document.getElementById("searchBook");
  const suggestionsBox = document.getElementById("suggestions");

  searchInput.addEventListener("input", () => {
    const query = searchInput.value.toLowerCase();
    suggestionsBox.innerHTML = ""; // Xóa gợi ý cũ

    if (query.length > 0) {
      fetchSuggestions(query).then((suggestions) => {
        suggestions.forEach((item) => {
          const div = document.createElement("div");
          div.classList.add("suggestion-item");
          div.textContent = item;
          div.addEventListener("click", () => {
            searchInput.value = item;
            suggestionsBox.innerHTML = ""; // Xóa gợi ý sau khi chọn
          });
          suggestionsBox.appendChild(div);
        });
      });
    }
  });

  function fetchSuggestions(query) {
    return new Promise((resolve) => {
      // Dữ liệu mẫu để kiểm tra
      const allBooks = [
        "Đắc Nhân Tâm",
        "Harry Potter",
        "One Piece",
        "Bí mật của hạnh phúc",
        "Cuộc đời của Pi",
      ];
      const filteredBooks = allBooks.filter((book) =>
        book.toLowerCase().includes(query)
      );
      resolve(filteredBooks);
    });
  }
});
