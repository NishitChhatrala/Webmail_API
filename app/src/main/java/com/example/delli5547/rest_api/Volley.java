 public void register_user(final String FirstName, final String LastName) {


        Log.d("RegisterActivity", "Register Method");

        String url = "http://quizcodes.esy.es/Quiz_Register.php";

        Log.d("RegisterActivity", "Url:" + url);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("RegisterActivity", "Response:" + response);
                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();

                try {
                    JSONObject mainObject = new JSONObject(response);
                    boolean success_TAG = mainObject.getBoolean("success");

                    session.setLogin(true);
                    if (success_TAG) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        session.setLogin(true);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {

                    public void onErrorResponse(VolleyError error) {


                        Log.d("RegisterActivity", "Eor");

                    }

                }

        ) {
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();

                Log.d("Names", "" + FirstName + "  " + LastName);
//                Toast.makeText(getApplicationContext(),""+FirstName + " "+LastName, Toast.LENGTH_SHORT).show();
                params.put("FirstName", FirstName);
                params.put("LastName", LastName);

                session.setLogin(true);

                return params;
            }

        };

        AppController.getInstance().addToRequestQueue(stringRequest, "req_register");
