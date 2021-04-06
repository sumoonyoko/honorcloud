  $(function(){
	  $("#push").click(function(){
		  var form=new FormData();
		  form.append("keywords",$("#keywords").val());
		  form.append("address",$("#address").val());
		  form.append("comment",$("#comment").val());
		  form.append("pushImg",$("#pushImg").val());
		  $.ajax({
				url:"../../backstage/push",
				fileElementId : 'pushImg',
				type:"post",
				cache: false,  
				processData:false,
				contentType:false,
				data:form,
			  	success:function(data){
			  		 var jsonData = JSON.parse(data);     
			  		 $("#pushStatus").html(jsonData.message);
			  	},
		 		 error: function(XMLHttpRequest, textStatus){
		             console.log(XMLHttpRequest); 
		             console.log(textStatus);
		         }
		 	 });
		 });
   });
