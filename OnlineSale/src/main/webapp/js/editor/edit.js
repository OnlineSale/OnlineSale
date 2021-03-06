function editor() {
    // Featured editor
    $('#editor0').each( function(index, element)
    {
        $(element).wysiwyg({
            'class': index == 0 ? 'fake-bootstrap' : (index == 1 ? 'fake-uikit' : 'some-more-classes'),
            // 'selection'|'top'|'top-selection'|'bottom'|'bottom-selection'
            toolbar: index == 0 ? 'top-selection' : (index == 1 ? 'bottom-focus' : 'selection'),
            buttons: {
                // Dummy-HTML-Plugin
                dummybutton1: index != 1 ? false : {
                    html: $('<input id="submit" type="button" value="Submit" />').click(function() {
                                alert( 'Submit form' );
                            }),
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                // Dummy-Button-Plugin
                dummybutton2: index != 1 ? false : {
                    title: 'Dummy',
                    image: '\uf1e7',
                    click: function( $button ) {
                                // We simply make 'bold'
                                if( $(element).wysiwyg('shell').getSelectedHTML() )
                                    $(element).wysiwyg('shell').bold();
                                else
                                    alert( 'No text selected' );
                           },
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                // Smiley plugin
                smilies: {
                    title: '插入表情',
                    image: '\uf118', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    popup: function( $popup, $button ) {
                            var list_smilies = [
                                    '<img src="images/smiley/afraid.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/amorous.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/angel.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/angry.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/bored.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/cold.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/confused.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/cross.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/crying.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/devil.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/disappointed.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/dont-know.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/drool.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/embarrassed.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/excited.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/excruciating.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/eyeroll.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/happy.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/hot.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/hug-left.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/hug-right.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/hungry.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/invincible.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/kiss.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/lying.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/meeting.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/nerdy.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/neutral.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/party.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/pirate.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/pissed-off.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/question.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/sad.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/shame.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/shocked.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/shut-mouth.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/sick.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/silent.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/sleeping.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/sleepy.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/stressed.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/thinking.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/tongue.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/uhm-yeah.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/wink.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/working.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/bathing.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/beer.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/boy.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/camera.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/chilli.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/cigarette.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/cinema.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/coffee.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/girl.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/console.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/grumpy.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/in_love.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/internet.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/lamp.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/mobile.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/mrgreen.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/musical-note.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/music.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/phone.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/plate.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/restroom.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/rose.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/search.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/shopping.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/star.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/studying.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/suit.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/surfing.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/thunder.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/tv.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/typing.png" width="16" height="16" alt="" />',
                                    '<img src="images/smiley/writing.png" width="16" height="16" alt="" />'
                            ];
                            var $smilies = $('<div/>').addClass('wysiwyg-plugin-smilies')
                                                      .attr('unselectable','on').attr('style','white-space: normal');
                            $.each( list_smilies, function(index,smiley) {
                                if( index != 0 )
                                    $smilies.append(' ');
                                var $image = $(smiley).attr('unselectable','on');
                                // Append smiley
                                var imagehtml = ' '+$('<div/>').append($image.clone()).html()+' ';
                                $image
                                    .css({ cursor: 'pointer' })
                                    .click(function(event) {
                                        $(element).wysiwyg('shell').insertHTML(imagehtml); // .closePopup(); - do not close the popup
                                    })
                                    .appendTo( $smilies );
                            });
                            var $container = $(element).wysiwyg('container');
                            $smilies.css({ maxWidth: parseInt($container.width()*0.95)+'px' });
                            $popup.append( $smilies );
                            // Smilies do not close on click, so force the popup-position to cover the toolbar
                            var $toolbar = $button.parents( '.wysiwyg-toolbar' );
                            if( ! $toolbar.length ) // selection toolbar?
                                return ;
                            return { // this prevents applying default position
                                left: parseInt( ($toolbar.outerWidth() - $popup.outerWidth()) / 2 ),
                                top: $toolbar.hasClass('wysiwyg-toolbar-bottom') ? ($container.outerHeight() - parseInt($button.outerHeight()/4)) : (parseInt($button.outerHeight()/4) - $popup.height())
                            };
                           },
                    //showstatic: true,    // wanted on the toolbar
                    showselection: index == 2 ? true : false    // wanted on selection
                },
                insertimage: {
                    title: '插入图片',
                    image: '\uf030', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: index == 2 ? true : false    // wanted on selection
                },
                insertvideo: {
                    title: '插入视频',
                    image: '\uf03d', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: index == 2 ? true : false    // wanted on selection
                },
                insertlink: {
                    title: '插入链接',
                    image: '\uf08e' // <img src="path/to/image.png" width="16" height="16" alt="" />
                },
                // Fontname plugin
                fontname: index == 1 ? false : {
                    title: '字体',
                    image: '\uf031', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    popup: function( $popup, $button ) {
                            var list_fontnames = {
                                    // Name : Font
                                    'Arial, Helvetica' : 'Arial,Helvetica',
                                    'Verdana'          : 'Verdana,Geneva',
                                    'Georgia'          : 'Georgia',
                                    'Courier New'      : 'Courier New,Courier',
                                    'Times New Roman'  : 'Times New Roman,Times'
                                };
                            var $list = $('<div/>').addClass('wysiwyg-plugin-list')
                                                   .attr('unselectable','on');
                            $.each( list_fontnames, function( name, font ) {
                                var $link = $('<a/>').attr('href','#')
                                                    .css( 'font-family', font )
                                                    .html( name )
                                                    .click(function(event) {
                                                        $(element).wysiwyg('shell').fontName(font).closePopup();
                                                        // prevent link-href-#
                                                        event.stopPropagation();
                                                        event.preventDefault();
                                                        return false;
                                                    });
                                $list.append( $link );
                            });
                            $popup.append( $list );
                           },
                    //showstatic: true,    // wanted on the toolbar
                    showselection: index == 0 ? true : false    // wanted on selection
                },
                // Fontsize plugin
                fontsize: index != 1 ? false : {
                    title: '字体大小',
                    style: 'color:white;background:red',      // you can pass any property - example: "style"
                    image: '\uf034', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    popup: function( $popup, $button ) {
                            // Hack: http://stackoverflow.com/questions/5868295/document-execcommand-fontsize-in-pixels/5870603#5870603
                            var list_fontsizes = [];
                            for( var i=8; i <= 11; ++i )
                                list_fontsizes.push(i+'px');
                            for( var i=12; i <= 28; i+=2 )
                                list_fontsizes.push(i+'px');
                                list_fontsizes.push('36px');
                                list_fontsizes.push('48px');
                                list_fontsizes.push('72px');
                            var $list = $('<div/>').addClass('wysiwyg-plugin-list')
                                                   .attr('unselectable','on');
                            $.each( list_fontsizes, function( index, size ) {
                                var $link = $('<a/>').attr('href','#')
                                                    .html( size )
                                                    .click(function(event) {
                                                        $(element).wysiwyg('shell').fontSize(7).closePopup();
                                                        $(element).wysiwyg('container')
                                                                .find('font[size=7]')
                                                                .removeAttr("size")
                                                                .css("font-size", size);
                                                        // prevent link-href-#
                                                        event.stopPropagation();
                                                        event.preventDefault();
                                                        return false;
                                                    });
                                $list.append( $link );
                            });
                            $popup.append( $list );
                           }
                    //showstatic: true,    // wanted on the toolbar
                    //showselection: true    // wanted on selection
                },
                // Header plugin
                header: index != 1 ? false : {
                    title: 'Header',
                    style: 'color:white;background:blue',      // you can pass any property - example: "style"
                    image: '\uf1dc', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    popup: function( $popup, $button ) {
                            var list_headers = {
                                    // Name : Font
                                    'Header 1' : '<h1>',
                                    'Header 2' : '<h2>',
                                    'Header 3' : '<h3>',
                                    'Header 4' : '<h4>',
                                    'Header 5' : '<h5>',
                                    'Header 6' : '<h6>',
                                    'Code'     : '<pre>'
                                };
                            var $list = $('<div/>').addClass('wysiwyg-plugin-list')
                                                   .attr('unselectable','on');
                            $.each( list_headers, function( name, format ) {
                                var $link = $('<a/>').attr('href','#')
                                                     .css( 'font-family', format )
                                                     .html( name )
                                                     .click(function(event) {
                                                        $(element).wysiwyg('shell').format(format).closePopup();
                                                        // prevent link-href-#
                                                        event.stopPropagation();
                                                        event.preventDefault();
                                                        return false;
                                                    });
                                $list.append( $link );
                            });
                            $popup.append( $list );
                           }
                    //showstatic: true,    // wanted on the toolbar
                    //showselection: false    // wanted on selection
                },
                bold: {
                    title: '加粗 (Ctrl+B)',
                    image: '\uf032', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    hotkey: 'b'
                },
                italic: {
                    title: '斜体 (Ctrl+I)',
                    image: '\uf033', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    hotkey: 'i'
                },
                underline: {
                    title: '下划线 (Ctrl+U)',
                    image: '\uf0cd', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    hotkey: 'u'
                },
                strikethrough: {
                    title: '取消线 (Ctrl+S)',
                    image: '\uf0cc', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    hotkey: 's'
                },
                forecolor: {
                    title: '字体颜色',
                    image: '\uf1fc' // <img src="path/to/image.png" width="16" height="16" alt="" />
                },
                highlight: {
                    title: '背景颜色',
                    image: '\uf043' // <img src="path/to/image.png" width="16" height="16" alt="" />
                },
                alignleft: index != 0 ? false : {
                    title: '左对齐',
                    image: '\uf036', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                aligncenter: index != 0 ? false : {
                    title: '居中',
                    image: '\uf037', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                alignright: index != 0 ? false : {
                    title: '右对齐',
                    image: '\uf038', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                alignjustify: index != 0 ? false : {
                    title: '两端对齐',
                    image: '\uf039', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                subscript: index == 1 ? false : {
                    title: '下标',
                    image: '\uf12c', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: true    // wanted on selection
                },
                superscript: index == 1 ? false : {
                    title: '上标',
                    image: '\uf12b', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: true    // wanted on selection
                },
                indent: index != 0 ? false : {
                    title: '缩进',
                    image: '\uf03c', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                outdent: index != 0 ? false : {
                    title: '取消缩进',
                    image: '\uf03b', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                orderedList: index != 0 ? false : {
                    title: '排序',
                    image: '\uf0cb', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                unorderedList: index != 0 ? false : {
                    title: '无序',
                    image: '\uf0ca', // <img src="path/to/image.png" width="16" height="16" alt="" />
                    //showstatic: true,    // wanted on the toolbar
                    showselection: false    // wanted on selection
                },
                removeformat: {
                    title: '移除格式',
                    image: '\uf12d' // <img src="path/to/image.png" width="16" height="16" alt="" />
                }
            },
            // Submit-Button
            submit: {
                title: 'Submit',
                image: '\uf00c' // <img src="path/to/image.png" width="16" height="16" alt="" />
            },
            // Other properties
            selectImage: 'Click or drop image',
            placeholderUrl: 'www.example.com',
            placeholderEmbed: '<embed/>',
            maxImageSize: [600,200],
            //filterImageType: callback( file ) {},
            onKeyDown: function( key, character, shiftKey, altKey, ctrlKey, metaKey ) {
                            // E.g.: submit form on enter-key:
                            //if( (key == 10 || key == 13) && !shiftKey && !altKey && !ctrlKey && !metaKey ) {
                            //    submit_form();
                            //    return false; // swallow enter
                            //}
                        },
            onKeyPress: function( key, character, shiftKey, altKey, ctrlKey, metaKey ) {
                        },
            onKeyUp: function( key, character, shiftKey, altKey, ctrlKey, metaKey ) {
                        },
            onAutocomplete: function( typed, key, character, shiftKey, altKey, ctrlKey, metaKey ) {
                            if( typed.indexOf('@') == 0 ) // startswith '@'
                            {
                                var usernames = [
                                        'Evelyn',
                                        'Harry',
                                        'Amelia',
                                        'Oliver',
                                        'Isabelle',
                                        'Eddie',
                                        'Editha',
                                        'Jacob',
                                        'Emily',
                                        'George',
                                        'Edison'
                                    ];
                                var $list = $('<div/>').addClass('wysiwyg-plugin-list')
                                                       .attr('unselectable','on');
                                $.each( usernames, function( index, username ) {
                                    if( username.toLowerCase().indexOf(typed.substring(1).toLowerCase()) !== 0 ) // don't count first character '@'
                                        return;
                                    var $link = $('<a/>').attr('href','#')
                                                        .text( username )
                                                        .click(function(event) {
                                                            var url = 'http://example.com/user/' + username,
                                                                html = '<a href="' + url + '">@' + username + '</a> ';
                                                            var editor = $(element).wysiwyg('shell');
                                                            // Expand selection and set inject HTML
                                                            editor.expandSelection( typed.length, 0 ).insertHTML( html );
                                                            editor.closePopup().getElement().focus();
                                                            // prevent link-href-#
                                                            event.stopPropagation();
                                                            event.preventDefault();
                                                            return false;
                                                        });
                                    $list.append( $link );
                                });
                                if( $list.children().length )
                                {
                                    if( key == 13 )
                                    {
                                        $list.children(':first').click();
                                        return false; // swallow enter
                                    }
                                    // Show popup
                                    else if( character || key == 8 )
                                        return $list;
                                }
                            }
                        },
            onImageUpload: function( insert_image ) {
                            var iframe_name = 'legacy-uploader-' + Math.random().toString(36).substring(2);
                            $('<iframe>').attr('name',iframe_name)
                                         .load(function() {
                                            // <iframe> is ready - we will find the URL in the iframe-body
                                            var iframe = this;
                                            var iframedoc = iframe.contentDocument ? iframe.contentDocument :
                                                           (iframe.contentWindow ? iframe.contentWindow.document : iframe.document);
                                            var iframebody = iframedoc.getElementsByTagName('body')[0];
                                            var image_url = iframebody.innerHTML;
                                            insert_image( image_url );
                                            $(iframe).remove();
                                         })
                                         .appendTo(document.body);
                            var $input = $(this);
                            $input.attr('name','upload-filename')
                                  .parents('form')
                                  .attr('action','/script.php') // accessing cross domain <iframes> could be difficult
                                  .attr('method','POST')
                                  .attr('enctype','multipart/form-data')
                                  .attr('target',iframe_name)
                                  .submit();
                        },
            forceImageUpload: false,    // upload images even if File-API is present
            videoFromUrl: function( url ) {
                // Contributions are welcome :-)

                // youtube - http://stackoverflow.com/questions/3392993/php-regex-to-get-youtube-video-id
                var youtube_match = url.match( /^(?:http(?:s)?:\/\/)?(?:[a-z0-9.]+\.)?(?:youtu\.be|youtube\.com)\/(?:(?:watch)?\?(?:.*&)?v(?:i)?=|(?:embed|v|vi|user)\/)([^\?&\"'>]+)/ );
                if( youtube_match && youtube_match[1].length == 11 )
                    return '<iframe src="//www.youtube.com/embed/' + youtube_match[1] + '" width="640" height="360" frameborder="0" allowfullscreen></iframe>';

                // vimeo - http://embedresponsively.com/
                var vimeo_match = url.match( /^(?:http(?:s)?:\/\/)?(?:[a-z0-9.]+\.)?vimeo\.com\/([0-9]+)$/ );
                if( vimeo_match )
                    return '<iframe src="//player.vimeo.com/video/' + vimeo_match[1] + '" width="640" height="360" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>';

                // dailymotion - http://embedresponsively.com/
                var dailymotion_match = url.match( /^(?:http(?:s)?:\/\/)?(?:[a-z0-9.]+\.)?dailymotion\.com\/video\/([0-9a-z]+)$/ );
                if( dailymotion_match )
                    return '<iframe src="//www.dailymotion.com/embed/video/' + dailymotion_match[1] + '" width="640" height="360" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>';

                // undefined -> create '<video/>' tag
            }
        })
        .change(function() {
            if( typeof console != 'undefined' )
                ;//console.log( 'change' );
        })
        .focus(function() {
            if( typeof console != 'undefined' )
                ;//console.log( 'focus' );
        })
        .blur(function() {
            if( typeof console != 'undefined' )
                ;//console.log( 'blur' );
        });
    });

    // Raw editor
    var option = {
        element: 'editor0', // or: document.getElementById('editor0')
        onKeyPress: function( key, character, shiftKey, altKey, ctrlKey, metaKey ) {
                        if( typeof console != 'undefined' )
                            console.log( 'RAW: '+character+' key pressed' );
                    },
        onSelection: function( collapsed, rect, nodes, rightclick ) {
                        if( typeof console != 'undefined' && rect )
                            console.log( 'RAW: selection rect('+rect.left+','+rect.top+','+rect.width+','+rect.height+'), '+nodes.length+' nodes' );
                    },
        onPlaceholder: function( visible ) {
                        if( typeof console != 'undefined' )
                            console.log( 'RAW: placeholder ' + (visible ? 'visible' : 'hidden') );
                    }
    };
    var wysiwygeditor = wysiwyg( option );
    //wysiwygeditor.setHTML( '<html>' );
}