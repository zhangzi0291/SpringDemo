$(function(){
	init()
})
var gfile,gbtn,gurl;
function init(){
	$('body').append("<div class='modal fade' id='progress' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
							+"		<div class='modal-dialog'>	"
							+"			<div class='modal-content'>"
							+"				<div class='modal-header'>"
							+"					<h4 class='modal-title' id='myModalLabel'>上传进度</h4>"
							+"				</div>"
							+"				<div class='modal-body'>"
							+"					<div class='progress progress-striped active'>"
							+"						<div class='progress-bar' role='progressbar'"
							+"							aria-valuenow='0' aria-valuemin='0' aria-valuemax='100'"
							+"							style=''>"
							+"							<span class='sr-only'>0% 完成</span>"
							+"						</div>"
							+"					</div>"
							+"				</div>"
							+"			</div>"
							+"		</div>"
							+"</div>")
}
/**
 * 
 * @param btn
 * @param file
 * @param url
 * @date 2017年2月15日 下午4:45:52
 * @author zxn
 */
function upload(btn,file,url){
	var fileValue = $("#file").val(); 
	if(fileValue == null || fileValue == ""){  
        layer.msg("请先选择文件");  
        return;  
    }  
	gbtn=btn;
	gfile=file;
	gurl=url;
		var fileValue = $('#'+gfile).val();  
		var obj = $('#'+gfile);  
		 $('div[role=progressbar]').width('0%');  
		 $(this).attr('disabled',true);  
		 $('#progress').modal({backdrop: 'static', keyboard: false});
         $('#progress').modal('show');
		 uploadFile2()
}
function uploadFile2(){
	var form = new FormData();  
	var fileObj = $('#'+gfile).get(0).files[0]; // js 获取文件对象  
    form.append('file', fileObj); // 文件对象  
	$.ajax({
	    type: "POST",
		url: gurl,
		data: form ,	//这里上传的数据使用了formData 对象
		processData : false, 
		//必须false才会自动加上正确的Content-Type 
		contentType : false , 
		//这里我们先拿到jQuery产生的 XMLHttpRequest对象，为其增加 progress 事件绑定，然后再返回交给ajax使用
		xhr: function(){
			var xhr = $.ajaxSettings.xhr();
			if(onprogress && xhr.upload) {
				xhr.upload.onprogress = progressFunction;
				return xhr;
			}
		}
	});
}
function uploadFile() {  
    var fileObj = $('#'+gfile).get(0).files[0]; // js 获取文件对象  
    console.info('上传的文件：'+fileObj);  
    var FileController = gurl; // 接收上传文件的后台地址   
    // FormData 对象  
    var form = new FormData();  
    // form.append('author', 'hooyes'); // 可以增加表单数据  
    form.append('file', fileObj); // 文件对象  
    // XMLHttpRequest 对象  
    var xhr = new XMLHttpRequest();  
    xhr.open('post', FileController, true);  
    xhr.upload.addEventListener('progress', progressFunction, true);  
    xhr.onreadystatechange =function(){
    	if(xhr.readyState == 4){ 
    		console.log("444444")
    		if(xhr.status == 200) {
    			layer.msg('上传完成');  
    	        $('#'+gbtn).attr('disabled', false);  
    	        $('#'+gbtn).text('上传');  
    	        $('div[role=progressbar]').parent().removeClass('active');  
    	        $('#progress').modal('hide');
    		}else if (xhr.status == 404 ) {
    			layer.msg('地址错误');  
    			$('#'+gbtn).attr('disabled', false);  
     	        $('#'+gbtn).text('上传');  
     	        $('div[role=progressbar]').parent().removeClass('active');  
    			$('#progress').modal('hide');
    			return 
    		}else if (xhr.status == 500 ) {
    			layer.msg('服务器异常');  
    			$('#'+gbtn).attr('disabled', false);  
     	        $('#'+gbtn).text('上传');  
     	        $('div[role=progressbar]').parent().removeClass('active');  
    			$('#progress').modal('hide');
    			return 
    		}else {
    			layer.msg('上传失败');  
    			$('#'+gbtn).attr('disabled', false);  
     	        $('#'+gbtn).text('上传');  
     	        $('div[role=progressbar]').parent().removeClass('active');  
    			$('#progress').modal('hide');
    			return 
    		}
    	}
    }
    xhr.send(form);  
}  


function progressFunction(evt) {  
    var progressBar = $('div[role=progressbar]');  
    if (evt.lengthComputable) {  
        var completePercent = Math.round(evt.loaded / evt.total * 100)+ '%';  
        progressBar.width(completePercent);  
        $('#'+gbtn).text('正在上传 ' + completePercent);  
    }
};  
