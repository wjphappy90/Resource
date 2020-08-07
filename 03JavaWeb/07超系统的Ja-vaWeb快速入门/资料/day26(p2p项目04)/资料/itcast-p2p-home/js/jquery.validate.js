/*
 * 
 *Jquery 的验证框架
 * 
 *notNull regex ajax equalTo rangeLength
 * 
 */
(function($){
    $.fn.validate = function(){
        //这里的this是Jquery的代理对象
        var form = this;
        var flag = true;
        form.submit(function(e){
            flag = true;
            e.preventDefault();
            form.find("input").each(function(){
                    $(this).blur();
            });
            if(flag){
                //解绑form表单注册的submit事件
                form.unbind("submit");
                form.submit();
            }
        });
        form.find("input").each(function(){
            //这里的this是当前迭代的dom对象
            var inputObj = $(this);
            //attr 代表的是html标签具备的属性
            //prop 代表的是js对象的属性 disabled checked
            var valiStr = inputObj.attr("validate");
            if(valiStr){
                inputObj.blur(function(){
                     //将json字符串转换成json对象
                    var validates = $.parseJSON(valiStr);
                    //[{"type":"notNull","msg":"用户名不能为空！"},{"type":"regex","reg":"","msg":""}]
                    for(var i = 0 ; i < validates.length ; i++){
                        var validate = validates[i];
                        //通过eval函数将 方法名执行获得函数实体对象
                        //eval(notNull); 将字符串当作js代码执行
                        var func = eval(validate.type);
                        if(func(inputObj,validate)){
                                tip(inputObj,'校验通过','blue');

                        }else{
                                tip(inputObj,validate.msg,'red');
                                flag = false;
                                return;
                        }
                    }
                });

            }
        });
        function notNull(obj,validate){
            var value = $.trim(obj.val());
            if(value.length==0){
                return false;
            }
            return true;
        }
        function regex(obj,validate){
            var regMatch = new RegExp(validate.reg);
            if(regMatch==null || regMatch =="null"){
                return true;
            }
            var result = $.trim(obj.val());
            if(!regMatch.test(result)){
                return false;
            }
            return true;
        }
        function equalTo(obj,validate){
            var v1 = $.trim(obj.val());
            var v2 = $.trim($(validate.target).val());
            if(v1==v2){
                return true;
            }
            return false;
        }
        function tip(obj,msg,color){
            var parent = obj.parent();
            var tips = parent.find("span");
            if(tips.length==0){
                obj.parent().append("<span><font color="+color+">"+msg+"</font></span>");
            }else{
                tips.html("<font color="+color+">"+msg+"</font>");
            }
        }

    }


})(jQuery);