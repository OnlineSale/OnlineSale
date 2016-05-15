    var tableData = null;
    var classifyDate = null;
    var classifyDate2 = null;
    function splitPage(page,pageSize,str){
            var ptable = document.getElementById("page_table");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
//清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
//设置参数
            var totalNums = tableData.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;
//向tbody中写入数据,不同页面的请求调用不同的方法
            //商品大分类页面
            if(str=="BigClassify"){
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var new_name = new_tr.insertCell();
                    var new_xiaolei = new_tr.insertCell();
                    var new_time = new_tr.insertCell();
                    var new_method = new_tr.insertCell();

                    new_xiaolei.innerHTML= tableData[i].C1;
                    new_time.innerHTML= tableData[i].C2;
                    new_name.innerHTML= "<a class='btn' onclick='showDetail("+tableData[i].Classify_ID+")'>"+tableData[i].C0+"</a>";
                    new_method.innerHTML= "<a class='btn btn-default'>删除</a><a class='btn btn-default'  data-toggle='modal' data-target='#Modal-update'>修改</a>";
                }
            };
            //商品小分类页面
            if(str=="SmallClassify"){
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var new_name = new_tr.insertCell();
                    var new_time = new_tr.insertCell();
                    var new_method = new_tr.insertCell();

                    new_time.innerHTML= tableData[i].C1;
                    new_name.innerHTML= tableData[i].C0;
                    new_method.innerHTML= "<a class='btn btn-default onclick='sendId("+tableData[i].Classify_ID+")'>删除</a><a class='btn btn-default'  data-toggle='modal' data-target='#Modal-update'>修改</a>";
                }
            };
            //出售中的商品页面
            if(str=="SellingGoods"){
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var new_checkbox = new_tr.insertCell();
                    var new_goods = new_tr.insertCell();
                    var new_kc = new_tr.insertCell();
                    var new_xl = new_tr.insertCell();
                    var new_time = new_tr.insertCell();
                    var new_method = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                                    +"<div class='row'>"
                                        +"<div class='col-md-3'></div>"
                                        +"<div class='col-md-3 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='"+tableData[i].img+"'/></div>"
                                        +"<div class='col-md-3 text-left'>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+tableData[i].name+"</div>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>￥："+tableData[i].price;+"</div>"
                                        +"</div>"
                                        +"<div class='col-md-3'></div>"
                                    +"</div>"
                                +"</div>"
                    new_checkbox.innerHTML= "<div class='checkbox'>"
                                               +"<label><input type='checkbox' class='all-choice' name='goods' value='"+tableData[i].goods_Id+"'></label>"
                                            +"</div>"
                    new_goods.innerHTML= content;
                    new_kc.innerHTML= tableData[i].kc;
                    new_xl.innerHTML= tableData[i].xl;
                    new_time.innerHTML= tableData[i].time;
                    new_method.innerHTML= "<a class='btn btn-default' value='"+tableData[i].goods_Id+"' onclick=''>复制</a><a class='btn btn-default' value='"+tableData[i].goods_Id+"'>修改</a><a class='btn btn-default' value='"+tableData[i].goods_Id+"' onclick=''>删除</a>";
                }
            };

            //仓库中的商品页面
            if(str=="WarehouseGoods"){
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var new_checkbox = new_tr.insertCell();
                    var new_goods = new_tr.insertCell();
                    var new_kc = new_tr.insertCell();
                    var new_xl = new_tr.insertCell();
                    var new_time = new_tr.insertCell();
                    var new_method = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                                    +"<div class='row'>"
                                        +"<div class='col-md-3'></div>"
                                        +"<div class='col-md-3 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='"+tableData[i].img+"'/></div>"
                                        +"<div class='col-md-3 text-left'>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+tableData[i].name+"</div>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>￥："+tableData[i].price;+"</div>"
                                        +"</div>"
                                        +"<div class='col-md-3'></div>"
                                    +"</div>"
                                +"</div>"
                    new_checkbox.innerHTML= "<div class='checkbox'>"
                                               +"<label><input type='checkbox' class='all-choice' name='goods' value='"+tableData[i].goods_Id+"'></label>"
                                            +"</div>"
                    new_goods.innerHTML= content;
                    new_kc.innerHTML= tableData[i].kc;
                    new_xl.innerHTML= tableData[i].xl;
                    new_time.innerHTML= tableData[i].time;
                    new_method.innerHTML= "<a class='btn btn-default' value='"+tableData[i].goods_Id+"' onclick=''>复制</a><a class='btn btn-default' value='"+tableData[i].goods_Id+"'>修改</a><a class='btn btn-default' value='"+tableData[i].goods_Id+"' onclick=''>删除</a>";
                }
            };

            //已售罄的商品页面
            if(str=="SellOut"){
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var new_checkbox = new_tr.insertCell();
                    var new_goods = new_tr.insertCell();
                    var new_kc = new_tr.insertCell();
                    var new_xl = new_tr.insertCell();
                    var new_time = new_tr.insertCell();
                    var new_method = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                                    +"<div class='row'>"
                                        +"<div class='col-md-3'></div>"
                                        +"<div class='col-md-3 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='"+tableData[i].img+"'/></div>"
                                        +"<div class='col-md-3 text-left'>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+tableData[i].name+"</div>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>￥："+tableData[i].price;+"</div>"
                                        +"</div>"
                                        +"<div class='col-md-3'></div>"
                                    +"</div>"
                                +"</div>"
                    new_checkbox.innerHTML= "<div class='checkbox'>"
                                               +"<label><input type='checkbox' class='all-choice' name='goods' value='"+tableData[i].goods_Id+"'></label>"
                                            +"</div>"
                    new_goods.innerHTML= content;
                    new_kc.innerHTML= tableData[i].kc;
                    new_xl.innerHTML= tableData[i].xl;
                    new_time.innerHTML= tableData[i].time;
                    new_method.innerHTML= "<a class='btn btn-default' value='"+tableData[i].goods_Id+"'>修改</a><a class='btn btn-default' value='"+tableData[i].goods_Id+"' onclick=''>删除</a>";
                }
            };



//生成分页工具条 
            var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage("+1+","+pageSize+",'"+str+"');\">首页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
            }
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage("+(page-1)+","+pageSize+",'"+str+"');\">上一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage("+(page+1)+","+pageSize+",'"+str+"');\">下一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage("+(totalPage)+","+pageSize+",'"+str+"');\">尾页</a></li> ";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
            }
            document.getElementById("page_bar").innerHTML = pageBar;
        }