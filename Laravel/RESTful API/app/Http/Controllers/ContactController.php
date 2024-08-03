<?php

namespace App\Http\Controllers;

use App\Http\Requests\Contact\ContactCreateRequest;
use App\Http\Requests\Contact\ContactDeleteRequest;
use App\Http\Requests\Contact\ContactUpdateRequest;
use App\Http\Requests\Contact\GetContactRequest;
use App\Http\Resources\ContactResource;
use App\Models\Contact;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\ResourceCollection;
use Illuminate\Support\Facades\Auth;

class ContactController extends Controller
{
    public function create(ContactCreateRequest $request): JsonResponse
    {
        $data = $request->validated();
        $user = Auth::user();

        $contact = new Contact($data);
        $contact->userId = $user->id;
        $contact->save();

        return (new ContactResource($contact))->response()->setStatusCode(201);
    }

    public function get(int $id, GetContactRequest $request): ContactResource
    {
        $contact = Contact::where('user_id', Auth::user()->id)->find($id);
        return new ContactResource($contact);
    }

    public function update(int $id, ContactUpdateRequest $request): ContactResource
    {
        $data = $request->validated();
        $user = Auth::user();

        $contact = Contact::where('user_id', $user->id)->find($id);
        $contact->fill($data);
        $contact->save();

        return new ContactResource($contact);
    }

    public function delete(int $id, ContactDeleteRequest $request): JsonResponse
    {
        $contact = Contact::where('user_id', Auth::user()->id)->find($id);
        $isDeleted = $contact->delete();
        return response()->json(['data' => $isDeleted]);
    }

    public function search(Request $request): ResourceCollection
    {
        $user = Auth::user();
        $page = $request->integer('page', 1);
        $size = $request->integer('size', 10);
        $builder = Contact::query()->where('user_id', $user->id);

        $builder->where(function (Builder $builder) use ($request) {
            if ($request->has('name')) {
                $name = $request->input('name');
                $builder->orWhere('first_name', 'LIKE', "%$name%");
                $builder->orWhere('last_name', 'LIKE', "%$name%");
            }
            if ($request->has('email')) {
                $email = $request->input('email');
                $builder->orWhere('email', 'LIKE', "%$email%");
            }
            if ($request->has('phone')) {
                $phone = $request->input('phone');
                $builder->orWhere('phone', 'LIKE', "%$phone%");
            }
        });

        $contacts = $builder->paginate(perPage: $size, page: $page);
        return ContactResource::collection($contacts);
    }
}
