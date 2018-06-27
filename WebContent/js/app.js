var app = {};
!(function(app, jQuery){
	jQuery.cookie = function(name, value, options) {
	    if (typeof value != 'undefined') { // name and value given, set cookie
	        options = options || {};
	        if (value === null) {
	            value = '';
	            options.expires = -1;
	        }
	        var expires = '';
	        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
	            var date;
	            if (typeof options.expires == 'number') {
	                date = new Date();
	                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
	            } else {
	                date = options.expires;
	            }
	            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
	        }
	        var path = options.path ? '; path=' + options.path : '';
	        var domain = options.domain ? '; domain=' + options.domain : '';
	        var secure = options.secure ? '; secure' : '';
	        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
	    } else { // only name given, get cookie
	        var cookieValue = null;
	        if (document.cookie && document.cookie != '') {
	            var cookies = document.cookie.split(';');
	            for (var i = 0; i < cookies.length; i++) {
	                var cookie = jQuery.trim(cookies[i]);
	                // Does this cookie string begin with the name we want?
	                if (cookie.substring(0, name.length + 1) == (name + '=')) {
	                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
	                    break;
	                }
	            }
	        }
	        return cookieValue;
	    }
	}
	/**
	 * ajax错误处理
	 */
	jQuery.ER = function(xhr, textStatus, exception){
    	var status = xhr.status; 
    	if(status){
    		switch (status) {
	    		case 403:
	    			$.messager.alert('警告','访问被拒绝','warning');
	    			break;
	    		case 404:
	    			$.messager.alert('警告','访问地址不存在或已删除','warning');
	    			break;
	    		case 500:
	    			$.messager.alert('警告','操作出现错误','warning');
	    			break;
	    		case 504:
	    			$.messager.alert('警告','请求超时','warning');
	    			break;
	    		case 0:
	    			$.messager.alert('警告','网络异常','warning');
	    			break;
	    		default:
	    			$.messager.alert('警告','错误代码['+status+']','warning');
	    			break;
    		}
    	}
    }
	/**
	 * localStorage
	 */
	jQuery.LS = {
	    get:function(dataKey){
	        if(window.localStorage)
	            return localStorage.getItem(dataKey);
	        else
	            return $.cookie(dataKey);  
	    },
	    set:function(key,value){            
	        if(window.localStorage)
	            localStorage[key]=value;
	        else
	            $.cookie(key,value);
	    },
	    remove:function(key){
	        if(window.localStorage)
	            localStorage.removeItem(key);
	        else
	            $.cookie(key,undefined);
	    }
	}
	/**
	 * sessionStorage
	 */
	jQuery.SS = {
	    get:function(dataKey){
	        if(window.sessionStorage)
	            return sessionStorage.getItem(dataKey);
	        else
	            return $.cookie(dataKey);  
	    },
	    set:function(key,value){            
	        if(window.sessionStorage)
	        	sessionStorage[key]=value;
	        else
	            $.cookie(key,value);
	    },
	    remove:function(key){
	        if(window.sessionStorage)
	        	sessionStorage.removeItem(key);
	        else
	            $.cookie(key,undefined);
	    }
	}
	/**
	 * cookie
	 */
	jQuery.CK = {
	    get:function(dataKey){
	        return jQuery.cookie(dataKey);  
	    },
	    set:function(key,value){            
	    	jQuery.cookie(key, value);
	    },
	    remove:function(key){
	    	jQuery.cookie(key, undefined);
	    }
	}
})(app, $);