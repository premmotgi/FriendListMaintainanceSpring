package com.devopstest.controller;

import com.devopstest.dao.Friend;
import com.devopstest.request.GetRequestBody;
import com.devopstest.request.PostRequestBody;
import com.devopstest.request.UpdateFriendRequestBody;
import com.devopstest.response.*;
import com.devopstest.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@RestController
public class FriendController{

    private final AtomicLong counter = new AtomicLong();

    private static final Logger LOGGER = Logger.getLogger(FriendController.class.getName());

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    AddFriendService addFriendService;

    @Autowired
    GetFriendService getFriendService;

    @Autowired
    DeleteFriendService deleteFriendService;

    @Autowired
    UpdateFriendService updateFriendService;

    @Autowired
    GetAllFriendsService getAllFriendsResponse;


    @GetMapping("/login")
    public LoginResponse greeting(@RequestParam(value = "name", defaultValue = "FriendUser") String name) throws Exception {


        LOGGER.info("Authentication request started with "+name);
        LoginResponse response =  authenticationService.execute(new Friend(counter.incrementAndGet(),name));

        LOGGER.info("Authentication ending with Response :" +response.toString());
        return  response;

    }

    @PostMapping("/friends")
    public PostFriendResponse addFriend(@RequestBody PostRequestBody postbody) throws Exception {


        if(ObjectUtils.isEmpty(postbody.getToken())){
            LOGGER.info("Request Unauthorised");
            return PostFriendResponse.build(postbody.friend, HttpStatus.BAD_REQUEST);

        }


        LOGGER.info("Add Friend request started with "+postbody.friend);
        PostFriendResponse response =  addFriendService.execute(postbody.friend, postbody.getToken());

        LOGGER.info("add friend ending with Response :" +response.toString());
        return  response;

    }


    @GetMapping("/friends")
    public GetFriendResponse getFriend(@RequestBody GetRequestBody getBody) throws Exception{

                if(getBody.getId() == 0){
                    LOGGER.info("Request Unauthorised");
                    return  GetFriendResponse.build(null, HttpStatus.BAD_REQUEST);
                }
        LOGGER.info("GET Friend service request started with "+getBody.getId());

        GetFriendResponse response = getFriendService.execute(getBody.getId());
        LOGGER.info("GET Friend request ending  with response "+response);

                return response;
    }


    @GetMapping("/friends/all")
    public GetAllFriendsResponse getAllFriend() throws Exception{


        LOGGER.info("GET all Friends service request started");

        GetAllFriendsResponse response = getAllFriendsResponse.execute();

        LOGGER.info("GET all Friends request ending  with response "+response);

        return response;
    }



    @DeleteMapping("/friends/{id}")
    public DeleteFriendResponse deleteFriend(@PathVariable Long id){

        if(id == 0){
            LOGGER.info("Request Unauthorised");
            return  DeleteFriendResponse.build(null, HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("Delete Friend service request started with "+id);

        DeleteFriendResponse response = deleteFriendService.execute(id);
        LOGGER.info("Delete Friend request ending  with response "+response);

        return response;


    }

    @PutMapping("/friends/{id}")
    public UpdateFriendResponse deleteFriend(@PathVariable Long id, @RequestBody UpdateFriendRequestBody updateBody){


        if(id == 0 || updateBody == null  ||updateBody.getFriend() == null || updateBody.getFriend().getId() != id){
            LOGGER.info("BAD REQUEST");
            return  UpdateFriendResponse.build(null, HttpStatus.BAD_REQUEST);
        }

        UpdateFriendResponse response = updateFriendService.execute(id, updateBody.getFriend());
        LOGGER.info("Update Friend request ending with response "+response);

        return response;


    }

}