
(function() {
	
	$("#products_list").on("click", ".js-delete", function() {

		let button = $(this);
		$("#delete_button").attr("data-id", button.attr("data-id"));
		
		$("#modalDelete").modal("show");
		
	})
	
	$("#delete_button").on("click", function() {
		let button = $(this);
		let id = button.attr("data-id");
		$.ajax({
			url: "/admin/products/delete/" + id,
			method: "GET",
			success: function() {
				window.location.href = "/admin/products"
			}
		})
	})
	
	window.addEventListener('scroll', function() {
		var scroll = window.scrollY || document.documentElement.scrollTop;
	
		// >=, não <=
		if (scroll >= 20) {
			// clearHeader, não clearheader - letra maiúscula H
			document.querySelector(".main-nav-items").classList.remove("d-none");
			document.querySelector(".main-nav").classList.add("shadow-sm");
		} else {
			document.querySelector(".main-nav-items").classList.add("d-none");
			document.querySelector(".main-nav").classList.remove("shadow-sm");
		}
	});
})()