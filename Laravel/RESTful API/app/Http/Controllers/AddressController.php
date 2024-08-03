<?php

namespace App\Http\Controllers;

use App\Http\Requests\Address\AddressCreateRequest;
use App\Http\Requests\Address\AddressUpdateRequest;
use App\Http\Resources\AddressResource;
use App\Http\Resources\ContactResource;
use App\Models\Address;
use App\Models\Contact;
use App\Models\User;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\AnonymousResourceCollection;
use Illuminate\Http\Resources\Json\ResourceCollection;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Auth;

class AddressController extends Controller
{
    protected function getContact(User $user, int $contactId): Contact
    {
        $contact = Contact::where('id', $contactId)->where('user_id', $user->id)->first();
        if (is_null($contact)) {
            throw new HttpResponseException(response()->json([
                'errors' => [
                    'message' => [
                        'The contact is not found.'
                    ]
                ]
            ], 404));
        }
        return $contact;
    }

    private function getAddress(Contact $contact, int $addressId): Address
    {
        $address = Address::where('id', $addressId)->where('contact_id', $contact->id)->first();
        if (is_null($address)) {
            throw new HttpResponseException(response()->json([
                'errors' => [
                    'message' => ['The address is not found.']
                ]
            ], 404));
        }
        return $address;
    }

    public function get(int $contactId, int $addressId, Request $request): AddressResource
    {
        $user = Auth::user();
        $contact = $this->getContact($user, $contactId);
        $address = $this->getAddress($contact, $addressId);
        return new AddressResource($address);
    }

    public function create(int $contactId, AddressCreateRequest $request): JsonResponse
    {
        $user = Auth::user();
        $contact = $this->getContact($user, $contactId);
        $data = $request->validated();
        $address = new Address($data);
        $address->contactId = $contact->id;
        $address->save();

        return (new AddressResource($address))->response()->setStatusCode(201);
    }

    public function update(int $contactId, int $addressId, AddressUpdateRequest $request): AddressResource
    {
        $user = Auth::user();
        $contact = $this->getContact($user, $contactId);
        $data = $request->validated();
        $address = $this->getAddress($contact, $addressId);
        $address->fill($data);
        $address->save();

        return new AddressResource($address);
    }

    public function delete(int $contactId, int $addressId, Request $request): JsonResponse
    {
        $user = Auth::user();
        $contact = $this->getContact($user, $contactId);
        $address = $this->getAddress($contact, $addressId);
        $isDeleted = $address->delete();
        return response()->json(['data' => $isDeleted]);
    }

    public function list(int $contactId): ResourceCollection
    {
        $user = Auth::user();
        $contact = $this->getContact($user, $contactId);
        $addresses = Address::where('contact_id', $contact->id)->get();
        if ($addresses->count() == 0) {
            throw new HttpResponseException(response()->json([
                'errors' => [
                    'message' => ['The addresses is not found.']
                ]
            ], 404));
        }
        return AddressResource::collection($addresses);
    }
}
