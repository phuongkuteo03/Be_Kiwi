document
  .getElementById("toggleSidebarBtn")
  .addEventListener("click", function () {
    document.querySelector(".sidebar").classList.toggle("hidden");
    document.querySelector(".content").classList.toggle("collapsed");
  });
